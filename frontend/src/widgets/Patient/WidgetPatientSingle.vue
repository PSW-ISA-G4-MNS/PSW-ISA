<script>

import PatientService from "./service";
import ClinicService from "../Clinic/service";
import DoctorService from "../Doctor/service.js"


import WidgetUserSingle from "../User/WidgetUserSingle.vue";
import MRService from "../Review/service";

export default {
    name: "WidgetPatientSingle",
    props: ["patient"],
    data: function(){
        return{
            data: {
		        id: null
	    },
	    role: localStorage.getItem("role"),
	    careRequest: false,
	    operationRequest: false,
	    medicalRecord: null,
        doctor: null,
        clinicId: null
        }
    },
    mounted: function()
    {
        PatientService.getSingle(this.patient).then(response => {
            this.data = response.data;
	        MRService.getMedicalRecord(this.patient).then(response => {
			    this.medicalRecord = response.data;
		    });
        });
        
        if (this.role == 'DOCTOR') {
            DoctorService.list().then(response => {
                console.log(response.data);
                this.doctor = response.data.filter(x => x.user.id == localStorage.getItem("user_id"))[0];
                console.log("Doctor id: " + this.doctor.id);
            });
            ClinicService.list().then(response => {
                if (response.data.length > 0) {
                    this.clinicId = response.data[0].id;
                }
            });
        }
    },
    methods: {
        submitOperationRequest: function() {
            PatientService.operationRequest({
                patientId: this.patient,
                clinicId: this.clinicId
            }).then(response => {
                this.$router.push("/scheduleOperation");
            });
        },
        submitCareRequest: function() {
            PatientService.careRequest(this.patient, {
                doctor: this.doctor,
                room: null, 
                careType: null, 
                startTime: null,
                endTime: null, 
                price: 1000,
                comment: "Additional care required for patient " + this.data.user.firstname + " " + this.data.user.lastname,
                medicalRecordId: null,
                diagnosis: null,
                prescription: null,
                approved: false
            }).then(response => {
                console.log("Care sent");
            });
        }
    },
    components: {
       "WidgetUserSingle": WidgetUserSingle
    }
}
</script>



<template>
    <div v-if="medicalRecord != null && data.id != null" class="widget-patient-single"> 
    <p> Jedinstveni broj osiguranika: {{data.insuranceID}} </p>
    <p>Weight: {{ medicalRecord.width}}</p>
    <p>Height: {{ medicalRecord.height}}</p>
    <p>Blood Type: {{ medicalRecord.bloodType}}</p>
    <WidgetUserSingle :user="data.user.id" />
    <button @click="submitOperationRequest" v-if="this.role == 'DOCTOR'">Request Operation</button>
    <button @click="submitCareRequest" v-if="this.role == 'DOCTOR'">Request New Care</button>

    </div>
</template>



<style>




</style>
