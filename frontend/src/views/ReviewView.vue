<script>


// import widgets for this view here
import Review from "../widgets/Review/Review.vue"

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
    	"Rreview": Review
    }
}
</script>

<template>

<Review/>

</template>

<style scoped> 



</style>
