<script>


// import widgets for this view here
import WidgetPatientMultiNurse from "../widgets/Patient/WidgetPatientMultiNurse.vue"

export default {
    name: "AllPatientsView",
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
    	"WidgetPatientMultiNurse": WidgetPatientMultiNurse
    }
}
</script>

<template>

<WidgetPatientMultiNurse/>

</template>

<style scoped> 



</style>
