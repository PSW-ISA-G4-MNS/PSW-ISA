<script>


// import widgets for this view here
import WidgetMedicine from "../widgets/Medicine/WidgetMedicine.vue"

export default {
    name: "MedicineAdd",
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
    	"WidgetMedicine": WidgetMedicine
    }
}
</script>

<template>

<WidgetMedicine/>

</template>

<style scoped> 



</style>
