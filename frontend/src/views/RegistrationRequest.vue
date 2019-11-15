<script>


// import widgets for this view here
import RegistrationRequestMulti from "../widgets/RegistrationRequest/RegistrationRequestMulti.vue"

export default {
    name: "RegistrationReques",
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
    	"RegistrationRequestMulti": RegistrationRequestMulti
    }
}
</script>>

<template>

<RegistrationRequestMulti/>

</template>

<style scoped> 



</style>
