<script>
import ClinicService from "./service";
import CareTypeService from "../CareType/service";
import Clinic from "./Clinic.vue";


export default {
    name: "multi-Clinic",
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
        }
    },
    mounted: function () 
    {
        ClinicService.list().then(response => this.items = response.data);
        CareTypeService.list().then(response => this.careTypes = response.data);
    },
    methods: {
        selectCareType: function(index) {
            console.log("Called with id = " + index);
            this.data.careTypeId = this.careTypes[index].id;
            localStorage.setItem("selectedCareType", this.careTypes[index].id)
            console.log("ID kertajpa = " + this.careTypes[index].id);
            this.careTypeName = this.careTypes[index].name;
        },
        filterClinics: function(){
            ClinicService.getWithFreeDoctors(this.data.careTypeId, this.data.date).then(response => this.items = response.data);
            console.log("kliknuto");
            localStorage.setItem("selectedDate", this.data.date);
        }
    },
    components: {
    	"Clinic": Clinic
    }
}
</script>



<template>

    <div class="dropdown">
        
		<input type="date" class="form-control" placeholder="birthday" v-model="data.date"/>
		
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonCareType" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    {{careTypeName}}
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonCareType">
		    <a :key="careType.id" :id="careType.id" @click="selectCareType(index)" v-for="(careType, index) in this.careTypes" class="dropdown-item" href="#">{{ careType.name }}</a>
		  </div>

        <div>
            <button v-on:click="filterClinics" style="background-color:green;color:white;height:40px;width:200px">
                Search
                </button>
		</div>

        <div class="multi-Clinic"> 
        <Clinic
            v-for="item in items.filter(filter)"
            :id="item.id"
            :key="item.id"
            :Clinic="item.id"
            />
        </div>
    </div>
</template>

<style scoped> 

.form-control, .btn, .button{
	padding: 10px; 
	width: 20%;
}

</style>
