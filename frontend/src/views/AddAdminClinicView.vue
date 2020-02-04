<script>


// import widgets for this view here
import AddAdminMulti from "../widgets/AddAdminClinic/AddAdminMulti.vue"

export default {
    name: "AddAdminClinicView",
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
    	"AddAdminMulti": AddAdminMulti
    }
}
</script>>

<template>

<AddAdminMulti/>

</template>

<style scoped> 



</style>
