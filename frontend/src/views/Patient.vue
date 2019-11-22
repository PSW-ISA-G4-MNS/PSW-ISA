<script>


// import widgets for this view here
import WidgetPatientSingle from "../widgets/Patient/WidgetPatientSingle.vue"

export default {
    name: "Patient",
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
    	"WidgetPatientSingle": WidgetPatientSingle
    }
}
</script>

<template>

<WidgetPatientSingle/>

</template>

<style scoped> 



</style>
