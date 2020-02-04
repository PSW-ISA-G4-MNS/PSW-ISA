<script>
import WidgetPatientMedicalRecord from '../widgets/PatientMedicalRecord/WidgetPatientMedicalRecord.vue';

// import widgets for this view here

export default {
    name: "PatientMedicalRecord",
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
        "WidgetPatientMedicalRecord": WidgetPatientMedicalRecord
    }
}
</script>

<template>

<WidgetPatientMedicalRecord />


</template>

<style scoped> 



</style>
