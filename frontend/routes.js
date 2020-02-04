import Home from './src/views/Home.vue';
import Login from './src/views/Login.vue';
import Registration from './src/views/Registration.vue';
import RegistrationRequest from './src/views/RegistrationRequest.vue';
import Profile from './src/views/Profile.vue';
import NewClinicView from './src/views/NewClinic.vue';
import CareList from './src/views/CareList.vue';
import ClinicList from './src/views/ClinicList.vue';

import PatientMedicalRecord from './src/views/PatientMedicalRecord.vue';
import CareHistory from './src/views/CareHistory.vue';

import ClinicDoctorsList from './src/views/ClinicDoctorsList.vue';

import ClinicReportView from './src/views/ClinicReportView.vue';

import CareFormView from './src/views/CareFormView.vue';
import LogOut from './src/views/Logout.vue';

import AvailableCaresForDoctor from './src/views/AvailableCaresForDoctor.vue';


import RoomEditView from './src/views/RoomEditView.vue';
import CareTypeList from './src/views/CareTypeList.vue';

import UpdateProfile from './src/views/UpdateProfile.vue';


import CalendarView from './src/views/CalendarView.vue';
import MedicineAdd from './src/views/MedicineAdd.vue';

import ReviewView from './src/views/ReviewView.vue';
import DiagnosisAdd from './src/views/DiagnosisAdd.vue';
import ChangeReviewView from './src/views/ChangeReviewView.vue';

const routes = [
    { path: '/', component: Home },
    { path: '/login', component: Login},
    { path: '/register', component: Registration},
    { path: '/regreq', component: RegistrationRequest},
    { path: '/clinic-new', component: NewClinicView},
    { path: '/CareList', component: CareList },
    { path: '/profile', component: Profile},
    { path: '/updateUser', component: UpdateProfile},
    { path: '/clinics', component: ClinicList},
    { path: '/createCare', component: CareFormView},
    { path: '/logout', component: LogOut},

    { path: '/ClinicDoctorsList', component: ClinicDoctorsList},
    { path: '/AvailableCaresForDoctor', component: AvailableCaresForDoctor},
    

    { path: '/patientMedicalRecord', component: PatientMedicalRecord},
    { path: '/patientCareHistory', component: CareHistory},

    { path: '/reports', component: ClinicReportView},
    { path: '/careTypes', component: CareTypeList},

    { path: '/calendar', component: CalendarView},
    {path: '/changeoldReview', component:ChangeReviewView},
    {path: '/review', component: ReviewView},
    {path: '/addDiagnosis', component: DiagnosisAdd},
    {path: '/addMedicine', component: MedicineAdd},

    { path: '/roomEdit/:room', component: RoomEditView, props: true},
   

];

export default routes;
