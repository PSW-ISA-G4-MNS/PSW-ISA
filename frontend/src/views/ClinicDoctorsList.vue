<script>


// import widgets for this view here
import WidgetDoctorMulti from "../widgets/Doctor/WidgetDoctorMulti.vue"

export default {
    name: "ClinicDoctorsList",
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
    	"WidgetDoctorMulti": WidgetDoctorMulti
    }
}
</script>

<template>

<WidgetDoctorMulti/>

</template>

<style scoped> 



</style>
