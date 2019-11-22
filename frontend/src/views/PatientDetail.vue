<script>

import PatientService from "../widgets/Patient/service"

import WidgetPatientASingle from "../widgets/Patient/WidgetPatientSingle.vue"

export default {
    name: "PatientDetail",
    props: ["patient"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	PatientService.get(this.patient).then(response => this.data = response.data)
    },
    components: {
        
        "WidgetUserMulti": WidgetUserMulti,

        "WidgetPatientSingle": WidgetPatientSingle,
    }
}
</script>>


<template>
    
</template>



<style scoped>

</style>