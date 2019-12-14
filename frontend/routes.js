import Home from './src/views/Home.vue';
import Login from './src/views/Login.vue';
import Registration from './src/views/Registration.vue';
import RegistrationRequest from './src/views/RegistrationRequest.vue';
import Profile from './src/views/Profile.vue';
import NewClinicView from './src/views/NewClinic.vue';
import CareList from './src/views/CareList.vue';
import ClinicList from './src/views/ClinicList.vue';
import CareFormView from './src/views/CareFormView.vue';

import UpdateProfile from './src/views/UpdateProfile.vue';


import ReviewView from './src/views/ReviewView.vue';
import DiagnosisAdd from './src/views/DiagnosisAdd.vue';


const routes = [
    { path: '/', component: Home },
    { path: '/login', component: Login},
    { path: '/register', component: Registration},

    { path: '/regreq', component: RegistrationRequest},
    { path: '/clinic-new', component: NewClinicView},
    { path: '/profile', component: Profile},
    { path: '/updateUser', component: UpdateProfile},
    { path: '/clinics', component: ClinicList},
    

    { path: '/cares', component: CareList},
    { path: '/createCare', component: CareFormView},
   
];

export default routes;
