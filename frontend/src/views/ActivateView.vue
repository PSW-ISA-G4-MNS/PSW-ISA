<script>
import PatientService from "../widgets/Patient/service";

// import widgets for this view here


export default {
    name: "ActivateView",
     props: ["hash"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {

        PatientService.activate(this.hash).then(response => {
            console.log("Proslo");
        });

    }
  
}
</script>

<template>



</template>

<style scoped> 



</style>
