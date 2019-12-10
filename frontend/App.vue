<script>


export default {
  name: "App",
  components: {

  }
}

</script>


<template>
  <div id="app">
    <nav>
        <router-link to='/'>Home</router-link>
        <router-link to='/login'>Login</router-link>
        <router-link to='/register'>Registration</router-link>

        <router-link to='/regreq'>RegistrationRequest</router-link>
        <router-link to='/profile'>My Profile</router-link>
        <router-link to='/clinic-new'>Create Clinic</router-link>
        <router-link to='/clinics'>Show all clinics</router-link>
        <router-link to='/createCare'>Add new care time</router-link>
    </nav>
    <router-view /> 
  </div>
</template>

<style scoped>

#app {
	margin: 20px;
}

</style>
