<script>


// import widgets for this view here
import ChangeOld from "../widgets/OldReviewChange/ChangeOld.vue"

export default {
    name: "ChangeSingleReviewView",
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
    	"ChangeOld": ChangeOld 
    }
}
</script>

<template>

<ChangeOld/>

</template>

<style scoped> 



</style>
