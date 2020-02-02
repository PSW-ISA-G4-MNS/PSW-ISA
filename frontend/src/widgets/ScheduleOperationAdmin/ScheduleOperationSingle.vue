<script>
import ScheduleOperationService from "./service";

export default {
	name: "ScheduleOperationSingle",
	props: ["operationRequest","newDate", "doctors"],
    data: function () {
        return {
            data: {},
          	care: {},
            success: false,
            

        };
    },
    methods: {
    	reservate: function() 
	{
		ScheduleOperationService.reservate(this.data).then(response => {
      console.log("Proslo")
		});
  

	},
		decline: function() 
	{
	}
  
  

	},
	
	mounted: function () 
    {
      this.data.patient=this.operationRequest.patient;
      this.data.startTime=this.newDateTime;
      this.data.doctors=this.doctors;
    
    }
}
</script>

<template>
    

  <tr >
      <td id="id">{{operationRequest.patient.user.id}}</td>
      <td id="firstname">{{operationRequest.patient.user.firstname}}</td>
      <td id="lastname">{{operationRequest.patient.user.lastname}}</td>
      <td id="time" v-if="operationRequest.startTime!=null">{{operationRequest.startTime.toString().replace("T", " ")}}</td>
      <td id="time" v-else>{{"No time"}}</td>
      <td id="realTime" v-if="newDate!=null">{{newDate}}</td>
      
      <td id="reservate">
              <button v-on:click="reservate" style="background-color:green;color:white;height:40px;width:200px">
              Reservate
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