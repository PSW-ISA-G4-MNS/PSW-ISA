<script>


// import widgets for this view here
import WidgetUpdatePatient from "../widgets/Patient/WidgetUpdatePatient.vue"

export default {
    name: "UpdateProfile",
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
    	"WidgetUpdatePatient": WidgetUpdatePatient
    }
}
</script>

<template>

<WidgetUpdatePatient/>

</template>

<style scoped> 



</style>
