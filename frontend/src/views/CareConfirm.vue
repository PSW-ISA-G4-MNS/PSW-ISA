<script>
import CareService from "../widgets/Care/service";

// import widgets for this view here


export default {
    name: "CareConfirm",
     props: ["careId"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {

        CareService.confirmation(this.careId).then(response => {
            console.log("Proslo");
        });

    }
  
}
</script>

<template>



</template>

<style scoped> 



</style>
