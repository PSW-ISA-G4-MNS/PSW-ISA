import Home from './src/views/Home.vue';
import Login from './src/views/Login.vue';
import Registration from './src/views/Registration.vue';
import RegistrationRequest from './src/views/RegistrationRequest.vue';
import Patient from './src/views/Patient.vue';
import NewClinicView from './src/views/NewClinic.vue';
import CareList from './src/views/CareList.vue';
import ClinicList from './src/views/ClinicList.vue';
import CareFormView from './src/views/CareFormView.vue';
import LogOut from './src/views/Logout.vue';

import UpdateProfile from './src/views/UpdateProfile.vue';


import ReviewView from './src/views/ReviewView.vue';
import DiagnosisAdd from './src/views/DiagnosisAdd.vue';


const routes = [
    { path: '/', component: Home },
    { path: '/login', component: Login},
    { path: '/register', component: Registration},

    { path: '/regreq', component: RegistrationRequest},
    { path: '/clinic-new', component: NewClinicView},
    { path: '/profile', component: Patient},
    { path: '/updateUser', component: UpdateProfile},
    { path: '/clinics', component: ClinicList},
    

    { path: '/cares', component: CareList},
    { path: '/createCare', component: CareFormView},
    { path: '/logout', component: LogOut},
   
];

export default routes;
