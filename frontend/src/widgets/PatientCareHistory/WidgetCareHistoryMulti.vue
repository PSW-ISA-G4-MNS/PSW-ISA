<script>
import CareHistoryService from "./service";
import CareTypeService from "../CareType/service";
import WidgetCareHistorySingle from "./WidgetCareHistorySingle.vue";


export default {
    name: "WidgetCareHistoryMulti",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: [],
            careTypes: [],
            careTypeName: "Select care type",
            data: {},
            role: localStorage.getItem('role')
        }
    },
    mounted: function () 
    {
        CareHistoryService.getCareHistory().then(response => this.items = response.data);
        CareTypeService.list().then(response => this.careTypes = response.data);
    },
    methods: {
        selectCareType: function(index) {
            console.log("Called with id = " + index);
            this.data.careTypeId = this.careTypes[index].id;
            localStorage.setItem("selectedCareTypeForHistory", this.careTypes[index].id)
            console.log("ID kertajpa = " + this.careTypes[index].id);
            this.careTypeName = this.careTypes[index].name;
        },
        filterCareHistory: function(){
            localStorage.setItem("selectedDateForHistory", this.data.date);
            if(this.data.careTypeId !== undefined && this.data.date !== undefined){
                CareHistoryService.filterCareHistory(this.data.careTypeId, this.data.date).then(response => this.items = response.data);
                console.log("kliknuto");
            } else {
                alert('Please select preffered date and care type to filter clinics.');
            }
        }
    },
    components: {
    	"WidgetCareHistorySingle": WidgetCareHistorySingle
    }
}
</script>


<template>



<h2 v-if = "items.length == 0">
        You have no care history.

        <input type="date" class="form-control" placeholder="careTime" v-model="data.date"/>
		
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonCareType" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    {{careTypeName}}
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonCareType">
		    <a :key="careType.id" :id="careType.id" @click="selectCareType(index)" v-for="(careType, index) in this.careTypes" class="dropdown-item" href="#">{{ careType.name }}</a>
		  </div>
        
        <div>
            <button v-on:click="filterCareHistory" style="background-color:green;color:white;height:40px;width:200px">
                Search
                </button>
		</div>
</h2>
<div v-else = "items.length != 0">
<h1>
    Care history
</h1>

        <input type="date" class="form-control" placeholder="careTime" v-model="data.date"/>
		
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonCareType" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    {{careTypeName}}
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonCareType">
		    <a :key="careType.id" :id="careType.id" @click="selectCareType(index)" v-for="(careType, index) in this.careTypes" class="dropdown-item" href="#">{{ careType.name }}</a>
		  </div>
        
        <div>
            <button v-on:click="filterCareHistory" style="background-color:green;color:white;height:40px;width:200px">
                Search
                </button>
		</div>


  <table >
    <tr>
        <th>Time </th>
        <th>Doctor </th>
        <th>Care type </th>
        <th>Diagnosis </th>
    </tr>
    
      <WidgetCareHistorySingle 
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :care="item"
          />
      
    
  </table>
</div>


</template>


<style scoped>

.form-control, .btn, .button{
	padding: 10px; 
	width: 20%;
}

body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #49bcf6;
  border-radius: 3px;
  background-color: #fff;
  width: 1320px;
}

th {
  background-color: #49bcf6;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #49bcf6;
}

th, td {
  min-width: 120px;
  padding: 10px 20px;
}

th.active {
  color: #fff;
}

th.active .arrow {
  opacity: 1;
}

.arrow {
  display: inline-block;
  vertical-align: middle;
  width: 0;
  height: 0;
  margin-left: 5px;
  opacity: 0.66;
}

.arrow.asc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-bottom: 4px solid #fff;
}

.arrow.dsc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-top: 4px solid #fff;
}


</style>