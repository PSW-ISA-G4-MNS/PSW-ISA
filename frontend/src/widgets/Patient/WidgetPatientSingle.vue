<script>

import PatientService from "./service";
import WidgetUserSingle from "../User/WidgetUserSingle.vue";

export default {
    name: "WidgetPatientSingle",
    props: ["patient"],
    data: function(){
        return{
            data: {}
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
    
    </div>
</template>



<style>




</style>
