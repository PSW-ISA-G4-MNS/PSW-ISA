<script>

import PatientProfileService from "./service";
import WidgetUserSingle from "../WidgetUserSingle.vue";

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
        PatientProfileService.show().then(response => {
            this.data = response.data;
        })
    },
    components: {
       "WidgetUserSingle": WidgetUserSingle
    }
}
</script>>



<template>
    <div class="widget-patient-single"> 
    <p> Jedinstveni broj osiguranika: {{this.insuranceid}} </p>
    <WidgetUserSingle :user="this.user_id" />
    
    </div>
</template>



<style>




</style>