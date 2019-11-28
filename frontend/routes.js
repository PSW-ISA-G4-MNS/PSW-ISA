import Home from './src/views/Home.vue';
import Login from './src/views/Login.vue';
import Registration from './src/views/Registration.vue';
import RegistrationRequest from './src/views/RegistrationRequest.vue';
import Patient from './src/views/Patient.vue';
import NewClinicView from './src/views/NewClinic.vue';
import CareList from './src/views/CareList.vue';


const routes = [
    { path: '/', component: Home },
    { path: '/login', component: Login},
    { path: '/register', component: Registration},

    { path: '/regreq', component: RegistrationRequest},
    { path: '/clinic-new', component: NewClinicView},
    { path: '/profile', component: Patient}
    { path: '/cares', component: CareList}
];

export default routes;
