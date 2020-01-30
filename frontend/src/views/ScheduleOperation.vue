<script>


// import widgets for this view here
import ScheduleOperationMulti from "../widgets/ScheduleOperationAdmin/ScheduleOperationMulti.vue"

export default {
    name: "ScheduleOperation",
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
    	"ScheduleOperationMulti": ScheduleOperationMulti
    }
}
</script>

<template>

<ScheduleOperationMulti/>

</template>

<style scoped> 



</style>
