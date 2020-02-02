<script>


// import widgets for this view here
import ReviewPage from "../widgets/Review/ReviewPage.vue"

export default {
    name: "ReviewView",
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

<ReviewPage/>

</template>

<style scoped> 



</style>
