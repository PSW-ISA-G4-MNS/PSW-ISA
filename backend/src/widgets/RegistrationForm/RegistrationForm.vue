<script>
import RegistrationFormService from "./service";

export default {
    name: "RegistrationForm",
    data: function () {
        return {
            data: {
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		RegistrationFormService.submit(this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	}
    }
}
</script>

<template>
    <div class="form-RegistrationForm"> 
        <div class="success-box" v-if="success"></div>
	<div v-if="!success"> 
		
		
		<p>
		<input type="text" class="form-control" placeholder="insurance ID" v-model="data.insuranceID" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="firstname" v-model="data.firstname" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="lastname" v-model="data.lastname" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="mobilePhone" v-model="data.mobilePhone" />
		</p>
		
		<p>
		<input type="email" class="form-control" placeholder="email" v-model="data.email" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="address" v-model="data.address" />
		</p>
		
		<p>
		<input type="password" class="form-control" placeholder="Password" v-model="data.password" />
		</p>
		
		<p>
		<input type="date" class="form-control" placeholder="birthday" v-model="data.birthday" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

.form-RegistrationForm {

}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
