<script>


// import widgets for this view here
import ReviewPage from "../widgets/Review/ReviewPage.vue"

export default {
    name: "ReviewView",
    props: ["patientIdFromCalendar","careIdFromCalendar"],
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
    	"ReviewPage": ReviewPage
    }
}
</script>

<template>

<ReviewPage
:patientId="this.patientIdFromCalendar"
:careId="this.careIdFromCalendar"
/>

</template>

<style scoped> 



</style>
