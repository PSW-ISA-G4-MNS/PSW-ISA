<script>
import OperationHistoryService from "./service";
import WidgetOperationHistorySingle from "./WidgetOperationHistorySingle.vue";


export default {
    name: "WidgetOperationHistoryMulti",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: [],
            data: {},
            role: localStorage.getItem('role')
        }
    },
    mounted: function () 
    {
        OperationHistoryService.getOperationHistory().then(response => this.items = response.data);
    },
    methods: {
        filterOperationHistory: function(){
            localStorage.setItem("selectedDateForHistory", this.data.date);
            if(this.data.date !== undefined){
                OperationHistoryService.filterOperationHistory(this.data.date).then(response => this.items = response.data);
                console.log("kliknuto");
            } else {
                alert('Please select preffered date to filter operations.');
            }
        }
    },
    components: {
    	"WidgetOperationHistorySingle": WidgetOperationHistorySingle
    }
}
</script>


<template>



<h2 v-if = "items.length == 0">
        You have no operation history.

        <input type="date" class="form-control" placeholder="operationTime" v-model="data.date"/>
		
        <div>
            <button v-on:click="filterOperationHistory" style="background-color:green;color:white;height:40px;width:200px">
                Search
                </button>
		</div>
</h2>
<div v-else = "items.length != 0">
<h1>
    Operation history
</h1>

        <input type="date" class="form-control" placeholder="operationTime" v-model="data.date"/>
		
        <div>
            <button v-on:click="filterOperationHistory" style="background-color:green;color:white;height:40px;width:200px">
                Search
                </button>
		</div>


  <table >
    <tr>
        <th>Doctors </th>
        <th>Time </th>
    </tr>
    
      <WidgetOperationHistorySingle 
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :operation="item"
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