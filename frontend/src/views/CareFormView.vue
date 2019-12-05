<script>


// import widgets for this view here
import CareForm from "../widgets/CareForm/CareForm.vue"

export default {
    name: "CareFormView",
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
    	"CareForm": CareForm
    }
}
</script>

<template>

<CareForm />

</template>

<style scoped> 



</style>
