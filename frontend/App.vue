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
    <nav>
        <router-link to='/'>Home</router-link>
        <router-link v-if='data.role == "NOT_LOGGED"' to='/login'>Login</router-link>
        <router-link v-if='data.role == "NOT_LOGGED"' to='/register'>Registration</router-link>

        <router-link v-if='data.role == "ADMIN" || data.role == "CLINIC_ADMIN"' to='/regreq'>Registration Requests</router-link>
        <router-link v-if="data.role != 'NOT_LOGGED'" to='/profile'>My Profile</router-link>
        <router-link v-if="data.role == 'ADMIN'" to='/clinic-new'>Create Clinic</router-link>
        <router-link v-if="data.role != 'NOT_LOGGED'" to='/clinics'>Show all clinics</router-link>
        <router-link v-if="data.role == 'CLINIC_ADMIN'" to='/createCare'>Add new care time</router-link>
	<p v-if="data.role != 'NOT_LOGGED'">{{ data.user.email }}</p>
    </nav>
    <router-view /> 
  </div>
</template>

<style scoped>

#app {
	margin: 20px;
}

</style>
