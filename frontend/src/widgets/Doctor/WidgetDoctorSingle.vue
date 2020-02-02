<script>
import DoctorService from "./service";

export default {
	name: "WidgetDoctorSingle",
	props: ["doctor"],
    data: function () {
        return {
          	doctor: {},
		        success: false

        };
    },
    methods: {
      availableCaresForDoctor: function(){
        localStorage.setItem('selectedDoctor', this.doctor.id);
        window.location.href = "/frontend/#/AvailableCaresForDoctor";
      }
    },
	mounted: function () 
    {
        DoctorService.get(this.doctor).then(

	response => {
		console.log(response.data);;
		this.doctor = response.data;
    
		console.log(this.data);
	}
	);
    }
}
</script>

<template>
    

  <tr v-if="!success">
      <td id="name">{{ doctor.user.firstname }} {{ doctor.user.lastname}}</td>
      <td id="caretype">{{ doctor.careType.name}}</td>
      <td id="availableCares">
              <button v-on:click="availableCaresForDoctor" style="background-color:green;color:white;height:40px;width:200px">
                Available cares
              </button>
        </td>
  </tr>
  
</template>

<style scoped>
body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #42b983;
  border-radius: 3px;
  background-color: #fff;
}

th {
  background-color: #42b983;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #f9f9f9;
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

</style>>