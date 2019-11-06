<script>
import LoginService from "./service";

export default {
    name: "WidgetLoginNew",
    data: function () {
        return {
            data: {
	    	userName: null,
		password: null,
	    	success: false
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		LoginService.login(this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	}
    }
}
</script>

<template>
    <div class="widget-login-new"> 
        <div class="success-box" v-if="success">Login succeded</div>
	<div v-if="!success"> 
		<p>
		<input type="email" class="form-control" placeholder="Username" v-model="data.userName" />
		</p>
		
		<p>
		<input type="password" class="form-control" placeholder="Password" v-model="data.password" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

.widget-login-new {
	padding: 10px; 
	background-color: #ffcccc; 
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
