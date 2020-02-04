<script>
import Service from "./service";
import ScheduleOperationSingle from "./ScheduleOperationSingle.vue";


export default {
    name: "ScheduleOperationMulti",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: [],
            datum:{},
            doctorsForOperation:{},
            pickedDoctors:[]
        }
    },
    mounted: function () 
    {
        Service.list().then(response => this.items = response.data);

         	Service.doctors().then(response => {
		this.doctorsForOperation = response.data; 
	});
    },
    components: {
    	"ScheduleOperationSingle": ScheduleOperationSingle
    },

    methods:{

    	selectDoctor: function(index) {
  
    $("#dropdownMenuDoctorButton").html(this.doctorsForOperation[index].user.firstname +" "+ this.doctorsForOperation[index].user.lastname);
		this.pickedDoctors.push(this.doctorsForOperation[index]);
		
    
      }
    
    }
}
</script>


<template>


<div >

<h2>
  Pick doctors and reservate
</h2>

    <div class="dropdown">
		  
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuDiagnosis">
		    <a :key="doctor.id" :id="doctor.id" @click="selectDoctor(index)" v-for="(doctor, index) in this.doctorsForOperation" class="dropdown-item" href="#">{{doctor.user.firstname}} {{doctor.user.firstname}}</a>
		  </div>
		  <button style="height:40px;width:180px" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuDoctorButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select Doctors
		  </button>
		</div>

   <table class='doctors' >
			<tr>
				<th>Doctors</th>
			</tr>

			<tr v-for="item in this.pickedDoctors"
				:id="item"
      	:key="item.id">
				<td >

				{{item.user.firstname}} {{item.user.lastname}}

				</td>


				
			</tr>
		</table>

  <table class='form'  >
    <tr>
        <th>Patient id</th>
        <th>Patient Firstname </th>
        <th>Patient LastName </th>
        <th>Planned OR time </th>
        <th>New OR time </th>
        <th></th>
    </tr>
    
      <ScheduleOperationSingle
      	v-for="item in items"
      	:id="item.id"
      	:key="item.id"
        :operationRequest="item"
        :doctors="pickedDoctors"
       
          />
      
    
  </table>
</div>


</template>


<style scoped>

.form {
position:relative;
    top:10%;
    left:10%;
	padding: 40px; 
	margin: 40px;
	text-align: center;
	width: 80%;
}


.doctors {
position:relative;
    top:10%;
    left:10%;
	padding: 40px; 
	margin: 40px;
	text-align: center;
	width: 80%;
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