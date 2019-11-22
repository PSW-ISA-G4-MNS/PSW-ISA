<script>
import LoginService from "./service";
//import router from '../../../router';

export default {
    name: "WidgetLoginNew",
    data: function () {
        return {
            data: {
	    	email: null,
		password: null,
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		LoginService.login(this.data).then(response => {
			console.log(response)
			if (response.status == 200) {
				this.data.success = true;
				localStorage.setItem("user", this.data.email);
				window.location.href = "/frontend/";
			}
			else {
				this.data.success = false;
				localStorage.setItem("user", null);
			}

		});
	}
    }
}
</script>

<template>
    <div class="widget-login-new"> 
		<p>
		<input type="email" class="form-control" placeholder="Username" v-model="data.email" />
		</p>
		
		<p>
		<input type="password" class="form-control" placeholder="Password" v-model="data.password" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
    </div>

</template>

<style scoped> 

.widget-login-new {
	padding: 10px; 
	margin: 10px;
	text-align: center;
	width: 20%;
}

.success-box 
{
	background-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
