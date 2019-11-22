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
</script>>



<template>
    <div class="widget-patient-single"> 
    <p> Jedinstveni broj osiguranika: {{data.insuranceid}} </p>
    <WidgetUserSingle :user="data.user" />
    
    </div>
</template>



<style>




</style>
