<script>
import ScheduleOperationService from "./service";
import RoomService from "../Room/service";

export default {
	name: "RoomOption",
	props: ["operationRequest","room", "doctors"],
    data: function () {
        return {
            data: {},
            success: false,
            request: {}
            

        };
    },
    methods: {
    	reservate: function() 
	{
      this.request.patient=this.operationRequest.patient;
      this.request.startTime=this.data.next;
      this.request.doctors=this.doctors;
		ScheduleOperationService.reservate(this.request).then(response => {
      console.log("Proslo")
		});
  

	},
		decline: function() 
	{
	}
  
  

	},
	
	mounted: function () 
    {
      RoomService.get(this.room).then(response => {
          this.data = response.data;
          RoomService.next(this.room).then(response => {
              this.data.next = response.data;
          });
      });

    
    }
}
</script>

<template>
    
<div :id="'widget-room-reservation-' + this.room">
    <p>{{data.name}} - available on {{ data.next.split("T")[0]}} at {{ data.next.split("T")[1] }}</p>
    <button @click="reservate">Schedule</button>
</div>
  
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