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
    </nav>
    <router-view /> 
  </div>
</template>

<style scoped>

#app {
	margin: 20px;
}

</style>
