<script>
import WidgetOperationHistoryMulti from '../widgets/PatientOperationHistory/WidgetOperationHistoryMulti.vue';


// import widgets for this view here

export default {
    name: "OperationHistory",
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
        "WidgetOperationHistoryMulti": WidgetOperationHistoryMulti
    }
}
</script>

<template>

<WidgetOperationHistoryMulti/>


</template>

<style scoped> 



</style>
