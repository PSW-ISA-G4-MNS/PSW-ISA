<script>
import AddAdminService from "./service";

export default {
    name: "AddAdminClinic",
    props: ["request"],
    data: function () {
        return {
          
                admin: {}
        };
    },
    methods: {
    	accept: function() 
	{
		AddAdminClinicService.accept(this.request).then(response => {


			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	}
	

	},
	
	mounted: function () 
    {
       AddAdminClinicService.get(this.request).then(response => {
		
		this.admin = response.data;
		
    }
	);
    }
}
</script>

<template>
    
    <b-dropdown-item> 
	{{admin.username}}
  </b-dropdown-item>
		


</template>

<style scoped> 



</style>
