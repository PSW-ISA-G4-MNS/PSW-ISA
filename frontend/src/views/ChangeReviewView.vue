<script>


// import widgets for this view here
import OldCareMulti from "../widgets/OldReviewChange/OldCareMulti.vue"

export default {
    name: "ChangeReviewView",
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
    	"OldCareMulti": OldCareMulti
    }
}
</script>

<template>

<OldCareMulti/>

</template>

<style scoped> 



</style>
