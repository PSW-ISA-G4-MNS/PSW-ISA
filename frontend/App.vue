<script>


export default {
  name: "App",
  data: function () {
	return {
		data: {
			user: {},
			role: "NOT_LOGGED"
		}
	}
  },
  components: {

  },
  mounted: function () {
	this.$store.subscribe((mutation, state) => {
		console.log("Logged as: ", state.user, " with role: ", state.role);
		console.log(this);
		this.data.user = state.user;
		this.data.role = state.role;
		console.log("State changed");
	})
  }
}

</script>


<template>
  <div id="app">
    <nav class="main-menu navbar navbar-dark bg-primary navbar-expand-lg">
	<div class="navbar-nav">
        <router-link to='/'>Home</router-link>

        <router-link v-if='data.role == "NOT_LOGGED"' to='/login'>Login</router-link>
        <router-link v-if='data.role == "NOT_LOGGED"' to='/register'>Registration</router-link>

        <router-link v-if='data.role == "ADMINISTRATOR" || data.role == "CLINIC_ADMINISTRATOR"' to='/regreq'>Registration Requests</router-link>
        <router-link v-if="data.role != 'NOT_LOGGED'" to='/profile'>My Profile</router-link>
        <router-link v-if="data.role != 'NOT_LOGGED'" to='/updateUser'>Update profile</router-link>
        <router-link v-if="data.role == 'ADMINISTRATOR'" to='/clinic-new'>Create Clinic</router-link>
        <router-link v-if="data.role != 'NOT_LOGGED'" to='/clinics'>Show all clinics</router-link>
        <router-link v-if="data.role == 'CLINIC_ADMINISTRATOR'" to='/createCare'>Add new care time</router-link>
	</div>
	
	<p class="my-2 my-lg-0" v-if="data.role != 'NOT_LOGGED'">Logged as: {{ data.user.email }}</p>

    </nav>
    <div class="view"><router-view /> </div>
  </div>
</template>

<style scoped>

.view {
	margin: 20px;
}

.main-menu a
{
	color: white;
	padding: 10px;
}
.main-menu a:hover 
{
	text-decoration: none;
	display: block;
	background: #bbbbff;
}

.main-menu p
{
	color: white;
}
</style>
