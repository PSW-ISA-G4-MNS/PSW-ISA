import Home from './src/views/Home.vue';
import Login from './src/views/Login.vue';

import RegistrationRequest from './src/views/RegistrationRequest.vue';
const routes = [
    { path: '/', component: Home },
    { path: '/login', component: Login},
      { path: '/register', component: Registration},

    { path: '/regreq', component: RegistrationRequest}
];

export default routes;
