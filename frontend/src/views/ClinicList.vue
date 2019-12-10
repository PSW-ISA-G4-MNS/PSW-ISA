<script>


//import widgets for this view here

import MultiClinic from '../widgets/Clinic/multi-Clinic.vue';

export default {
    name: "ClinicList",
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
    	"multi-Clinic": MultiClinic
    }
}
</script>

<template>

<multi-Clinic />

</template>

<style scoped> 



</style>
