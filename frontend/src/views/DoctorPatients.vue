<script>


// import widgets for this view here

import PatientsWidget from "../widgets/Doctor/multi-DoctorPatient.vue";

export default {
    name: "Login",
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
    	PatientsWidget
    }
}
</script>

<template>

<PatientsWidget />

</template>

<style scoped> 



</style>
