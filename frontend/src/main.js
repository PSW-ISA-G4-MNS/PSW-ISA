import Vue from 'vue'
import App from '../App.vue'
import VueRouter from 'vue-router'
import router from '../router';

new Vue({
    router,
    el: '#app',
    render: h => h(App),
}).$mount("#app")


