<script>
import DoctorSingleService from "../Doctor/service";

export default {
	name: "DoctorOption",
	props: ["Doctor",],
    data: function () {
        return {
            data: {
            },
            success: false,            

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
      console.log("Getting for Doctor: " + this.Doctor);
      DoctorSingleService.get(this.Doctor).then(response => {
          this.data = response.data;
          this.success = true;
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
    <p v-if="this.success">{{data.user.firstname + " " + data.user.lastname}}
    <button @click="reservate">Select</button>
    </p>
</template>

<style scoped>

</style>