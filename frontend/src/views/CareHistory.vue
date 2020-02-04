<script>
import WidgetCareHistoryMulti from '../widgets/PatientCareHistory/WidgetCareHistoryMulti.vue';


// import widgets for this view here

export default {
    name: "CareHistory",
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
        "WidgetCareHistoryMulti": WidgetCareHistoryMulti
    }
}
</script>

<template>

<WidgetCareHistoryMulti/>


</template>

<style scoped> 



</style>
