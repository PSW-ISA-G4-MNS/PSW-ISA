<script>

import PatientService from "./service";
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
	    medicalRecord: null
        }
    },
    mounted: function()
    {
        PatientService.getSingle(this.patient).then(response => {
            this.data = response.data;
	    MRService.getMedicalRecord(this.patient).then(response => {
			this.medicalRecord = response.data;
		})
        });

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
    <button @click="careRequest = !careRequest" v-if="this.role == 'DOCTOR'">Request Care</button>
    <button @click="operationRequest = !operationRequest" v-if="this.role == 'DOCTOR'">Request Operation</button>
    </div>
</template>



<style>




</style>
