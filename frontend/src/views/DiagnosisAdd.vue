<script>


// import widgets for this view here
import WidgetDiagnosis from "../widgets/Diagnosis/WidgetDiagnosis.vue"

export default {
    name: "DiagnosisAdd",
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
    	"WidgetDiagnosis": WidgetDiagnosis
    }
}
</script>

<template>

<WidgetDiagnosis/>

</template>

<style scoped> 



</style>
