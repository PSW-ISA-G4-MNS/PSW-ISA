<script>


// import widgets for this view here
import AddAdminClinicMulti from "../widgets/AddAdminClinic/AddAdminClinicMulti.vue"

export default {
    name: "AddAdminClinic",
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
    	"AddAdminClinicMulti": AddAdminClinicMulti
    }
}
</script>>

<template>

<AddAdminClinicMulti/>

</template>

<style scoped> 



</style>
