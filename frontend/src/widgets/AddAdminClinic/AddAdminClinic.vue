<script>
import AddAdminService from "./service";

export default {
    name: "AddAdminClinic",
    props: ["request"],
    data: function () {
        return {
          

        };
    },
    methods: {
    	accept: function() 
	{
		RegistrationRequestService.accept(this.request).then(response => {


			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	}
	

	},
	
	mounted: function () 
    {
        RegistrationRequestService.get(this.request).then(response => this.data = response.data);
    }
}
</script>

<template>
    
    <b-dropdown-item> 
	{{request.username}}
  </b-dropdown-item>
		


</template>

<style scoped> 



</style>
