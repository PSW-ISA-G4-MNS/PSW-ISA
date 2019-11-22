<script>


// import widgets for this view here
import NewClinic from "../widgets/NewClinic/NewClinic.vue"

export default {
    name: "NewClinicView",
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
    	"NewClinic": NewClinic
    }
}
</script>

<template>

<NewClinic/>

</template>

<style scoped> 



</style>
