<script>


// import widgets for this view here
import WidgetAvailableCareMulti from "../widgets/AvailableCare/WidgetAvailableCareMulti.vue"

export default {
    name: "AvailableCaresForDoctor",
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
    	"WidgetAvailableCareMulti": WidgetAvailableCareMulti
    }
}
</script>

<template>

<WidgetAvailableCareMulti/>

</template>

<style scoped> 



</style>
