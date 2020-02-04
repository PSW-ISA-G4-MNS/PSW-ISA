<script>
import ScheduleOperationService from "./service";
import RoomSingleService from "../Room/service";

export default {
	name: "RoomOption",
	props: ["operationRequest","room", "doctors"],
    data: function () {
        return {
            data: {
              newStartTime: null
            },
            success: false,
            request: {}
            

        };
    },
    methods: {
    	reservate: function() 
	    {
        this.request.patient=this.operationRequest.patient;
        this.request.startTime=this.data.newStartTime;
        this.request.doctors=this.doctors;
        this.request.room = this.data;
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
      console.log("Getting for room: " + this.room);
      RoomSingleService.get(this.room).then(response => {
          this.data = response.data;
          RoomSingleService.next(this.room).then(response => {
              this.data.newStartTime = response.data;
              this.success = true;
          });
      });

    
    },
  
  computed: {
    available: function () {
      return this.data.newStartTime.replace("T", " at ");
    }
  }
}
</script>

<template>
    <p v-if="this.success">{{data.title + " at" + data.newStartTime.replace("T", "")}}
    <button @click="reservate">Schedule</button>
    </p>
</template>

<style scoped>

</style>>