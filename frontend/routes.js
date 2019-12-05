import Home from './src/views/Home.vue';
import Login from './src/views/Login.vue';
import Registration from './src/views/Registration.vue';
import RegistrationRequest from './src/views/RegistrationRequest.vue';
import Patient from './src/views/Patient.vue';
import NewClinicView from './src/views/NewClinic.vue';
import CareList from './src/views/CareList.vue';
import ClinicList from './src/views/ClinicList.vue';
import CareFormView from './src/views/CareFormView.vue';


const routes = [
    { path: '/', component: Home },
    { path: '/login', component: Login},
    { path: '/register', component: Registration},

    { path: '/regreq', component: RegistrationRequest},
    { path: '/clinic-new', component: NewClinicView},
    { path: '/profile', component: Patient},
    { path: '/clinics', component: ClinicList},

    { path: '/cares', component: CareList},
    { path: '/createCare', component: CareFormView}
];

export default routes;
