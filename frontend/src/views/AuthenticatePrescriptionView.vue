<script>


// import widgets for this view here
import AuthenticatePrescriptionMulti from "../widgets/AuthenticatePrescription/AuthenticatePrescriptionMulti.vue"

export default {
    name: "AuthenticatePrescriptionView",
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    },
    methods: {
        submit: function (event) 
        {
            
        }
    },
    components: {
    	"AuthenticatePrescriptionMulti": AuthenticatePrescriptionMulti
    }
}
</script>

<template>

<AuthenticatePrescriptionMulti/>

</template>

<style scoped> 



</style>
