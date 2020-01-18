<script>


//import widgets for this view here

import MultiClinicReport from '../widgets/Clinic/multi-ClinicReport.vue';

export default {
    name: "ClinicReportView",
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
    	"multi-ClinicReport": MultiClinicReport
    }
}
</script>

<template>

<multi-ClinicReport />

</template>

<style scoped> 



</style>
