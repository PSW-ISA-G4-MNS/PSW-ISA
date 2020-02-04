<script>
import  AddAdminClinicService from "./service";
import AddAdminSingle from "./AddAdminSingle.vue";


export default {
    name: "AddAdminMulti",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: [],
            clinics:[],
            pickedClinic:{},
        }

    },

     methods:{

    	selectClinic: function(index) {
  
    $("#dropdownMenuClinicButton").html(this.clinics[index].name);
		this.pickedClinic=this.clinics[index].id;
		
    
      }
    
    },

    mounted: function () 
    {
        AddAdminClinicService.list().then(response => this.items = response.data);

        AddAdminClinicService.getClinics().then(response => this.clinics = response.data);
    },
    components: {
    	"AddAdminSingle": AddAdminSingle
    }
}
</script>

<template>
  <div class="AddAdminSingle"> 
    

    

<h2>
  Pick Clinic to add Admin
</h2>

    <div class="dropdown">
		  
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuDiagnosis">
		    <a :key="clinic.id" :id="clinic.id" @click="selectClinic(index)" v-for="(clinic, index) in this.clinics" class="dropdown-item" href="#">{{clinic.name}}</a>
		  </div>
		  <button style="height:40px;width:180px" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuClinicButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select Clinic
		  </button>
		</div>

  

  <table class='form'  >
    <tr>
       
        <th>Patient Firstname </th>
        <th>Patient LastName </th>
        
        <th>Add Admin</th>
        <th></th>
    </tr>
    
      <AddAdminSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :admin="item"
        :idKlinike="pickedClinic"
          />
      
    
  </table>

</div>
</template>

<style scoped> 

.form {
position:relative;
    top:20%;
    left:20%;
	padding: 40px; 
	margin: 40px;
	text-align: center;
	width: 60%;
}


input{
width: 50%;
  padding: 12px 20px;
  
  box-sizing: border-box;
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