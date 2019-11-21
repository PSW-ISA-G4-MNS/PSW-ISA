<script>

import WidgetUserMulti from "./src/widgets/User/WidgetUserMulti.vue";
import WidgetUserNew from "./src/widgets/User/WidgetUserNew.vue";
import WidgetLoginNew from "./src/widgets/Auth/WidgetLoginNew.vue";
import AdminDetail from "./src/views/AdminDetail.vue";

export default {
  name: "App",
  components: {
    "WidgetUserMulti": WidgetUserMulti,
    "WidgetUserNew": WidgetUserNew,
    "AdminDetail": AdminDetail,
    "WidgetLoginNew": WidgetLoginNew,
    
    
  }
}

</script>


<template>
  <div id="app">
    <nav>
        <router-link to='/'>Home</router-link>
        <router-link to='/login'>Login</router-link>
        <router-link to='/register'>Registration</router-link>
       
    </nav>
    <router-view />
  </div>
</template>
