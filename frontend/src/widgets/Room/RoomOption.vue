<script>
import ScheduleOperationService from "./service";
import RoomSingleService from "../Room/service";

export default {
	name: "RoomOption",
	props: ["room",],
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
        this.$emit("select", this.data);
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
              console.log("Getting next available time slot for room " + this.room);
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
    <button @click="reservate">Select</button>
    </p>
</template>

<style scoped>

</style>>