<script>
import CareFormService from "./service";


export default {
    name: "AddAdminClinic",
    data: function () {
        return {
            data: {
	    },
	    admins: [],
	    success: false

        };
    },
    mounted: function() {
    	AdminService.list().then(response => {
		this.admins = response.data; 
	});
    	
    },
    methods: {
    	submit: function() 
	{
		AddAdminClinicService.submit(this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	},
	selectAdmin: function(index) {
		console.log("Dodat admin= " + index);
		this.data.admin = this.admins[index].id;
	},
	
    }
}
</script>

<template>
    <div class="form-AdminForm"> 
        <div class="success-box" v-if="success">Care created</div>
	<div v-if="!success"> 
		
		<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonDoctor" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select doctor
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonAdmin">
		    <a :key="admin.id" :id="admin.id" @click="selectDoctor(index)" v-for="(admin, index) in this.doctors" class="dropdown-item" href="#">{{ doctor.user.firstname }} {{ doctor.user.lastname}}</a>
		  </div>
		</div>

		<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonAdminDoctor" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select doctor
		  </button>
		
		
    </div>

</template>

<style scoped> 


.success-box 
{
	background-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
