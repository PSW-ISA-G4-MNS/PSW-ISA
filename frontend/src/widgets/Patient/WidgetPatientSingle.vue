<script>

import PatientService from "./service";
import WidgetUserSingle from "../User/WidgetUserSingle.vue";

export default {
    name: "WidgetPatientSingle",
    props: ["patient"],
    data: function(){
        return{
            data: {},
	    role: localStorage.getItem("role"),
	    careRequest: false,
	    operationRequest: false,
        }
    },
    mounted: function()
    {
        PatientService.get().then(response => {
            this.data = response.data;
        })
    },
    components: {
       "WidgetUserSingle": WidgetUserSingle
    }
}
</script>



<template>
    <div class="widget-patient-single"> 
    <p> Jedinstveni broj osiguranika: {{data.insuranceID}} </p>
    <WidgetUserSingle :user="data.user.id" />
    <button @click="careRequest = !careRequest" v-if="this.role == 'DOCTOR'">Request Care</button>
    <button @click="operationRequest = !operationRequest" v-if="this.role == 'DOCTOR'">Request Operation</button>
    </div>
</template>



<style>




</style>
