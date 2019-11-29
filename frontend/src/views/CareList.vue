<script>


// import widgets for this view here
import WidgetCareMulti from "../widgets/Care/WidgetCareMulti.vue"

export default {
    name: "CareList",
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
    	"WidgetCareMulti": WidgetCareMulti
    }
}
</script>

<template>

<WidgetCareMulti/>

</template>

<style scoped> 



</style>
