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
import OperationHistory from './src/views/OperationHistory.vue';


import ClinicDoctorsList from './src/views/ClinicDoctorsList.vue';

import ClinicReportView from './src/views/ClinicReportView.vue';

import CareFormView from './src/views/CareFormView.vue';
import LogOut from './src/views/Logout.vue';


import AvailableCaresForDoctor from './src/views/AvailableCaresForDoctor.vue';

import RoomEditView from './src/views/RoomEditView.vue';
import CareTypeList from './src/views/CareTypeList.vue';

import UpdateProfile from './src/views/UpdateProfile.vue';


import DoctorPatients from "./src/views/DoctorPatients.vue"
import ScheduleCare from "./src/views/ScheduleCare.vue";

import VacationRequestList from "./src/views/VacationRequestList.vue";


import CalendarView from './src/views/CalendarView.vue';
import MedicineAdd from './src/views/MedicineAdd.vue';

import ActivateView from './src/views/ActivateView.vue';

import ReviewView from './src/views/ReviewView.vue';
import DiagnosisAdd from './src/views/DiagnosisAdd.vue';
import ChangeReviewView from './src/views/ChangeReviewView.vue';

import System from './src/views/System.vue';
import AuthenticatePrescriptionView from './src/views/AuthenticatePrescriptionView.vue';

import PatientDetail from "./src/views/PatientDetail.vue";
import CareConfirm from "./src/views/CareConfirm.vue";
import CareDecline from "./src/views/CareDecline.vue";



import AddAdminClinicView from './src/views/AddAdminClinicView.vue';


import AllPatientsView from "./src/views/AllPatientsView.vue";

const routes = [
    { path: '/', component: Home },
    { path: '/login', component: Login},
    { path: '/register', component: Registration},
    { path: '/regreq', component: RegistrationRequest},
    { path: '/clinic-new', component: NewClinicView},
    { path: '/patients', component: AllPatientsView},
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
    { path: '/patientOperationHistory', component: OperationHistory},

    { path: '/reports', component: ClinicReportView},
    { path: '/careTypes', component: CareTypeList},
    { path: '/schedule/care', component: ScheduleCare},
    { path: '/schedule/operation', component: ScheduleOperation},
    { path: '/vrm', component: VacationRequestList},

    { path: '/calendar', component: CalendarView},
    {path: '/changeoldReview', component:ChangeReviewView},
    {path: '/scheduleOperation', component:ScheduleOperation},
    {path: '/review', component: ReviewView},
    {path: "/review/:patientIdFromCalendar/:careIdFromCalendar", component: ReviewView, props: true},
    {path: "/activate/:hash", component: ActivateView, props:true},
    {path: '/addDiagnosis', component: DiagnosisAdd},
    {path: '/addMedicine', component: MedicineAdd},
    {path: '/addAdminClinic', component:AddAdminClinicView},

    { path: '/roomEdit/:room', component: RoomEditView, props: true},
    { path: "/patients/:patient", component: PatientDetail, props: true},
    { path: "/confirm/:careId", component: CareConfirm, props: true},
    { path: "/decline/:careId", component: CareDecline, props: true},
   {path: '/sys', component: System},
   {path: '/prescription', component: AuthenticatePrescriptionView},
   

];

export default routes;
