<script>


import CalendarWidget from "../widgets/Calendar/CalendarWidget.vue"

export default {
    name: "CalendarView",
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
    	"CalendarWidget": CalendarWidget
    }
}
</script>

<template>

<CalendarWidget/>

</template>

<style scoped> 



</style>
