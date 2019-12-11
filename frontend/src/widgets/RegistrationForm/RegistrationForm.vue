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
			if (response.status < 300) window.location.href = "/frontend/";
		});
	}
    }
}
</script>

<template>
    <div class="form-RegistrationForm"> 
        <div class="success-box" ></div>
		
		<h2>Registration</h2>
		
		<p>
		<input type="text" class="form-control" placeholder="Insurance ID" v-model="data.insuranceid" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="Firstname" v-model="data.name" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="Lastname" v-model="data.lastname" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="MobilePhone" v-model="data.mobile_phone" />
		</p>
		
		<p>
		<input type="email" class="form-control" placeholder="Email" v-model="data.email" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="Address" v-model="data.address" />
		</p>
		
		<p>
		<input type="password" class="form-control" placeholder="Password" v-model="data.password" />
		</p>
		
		<p>
		<input type="date" class="form-control" placeholder="Birthday" v-model="data.birthday" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
		&nbsp;
		&nbsp;
		<a href="http://127.0.0.1:300/frontend/#/login">If you already have account, click here to login</a>
		
	</div>
    

</template>

<style scoped> 

.form-RegistrationForm {
	position:fixed;
    top:10%;
    left:40%;
	padding: 10px; 
	margin: 10px;
	text-align: center;
	width: 20%;
}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
