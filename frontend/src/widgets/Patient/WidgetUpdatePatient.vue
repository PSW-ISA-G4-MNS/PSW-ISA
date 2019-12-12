<script>

import PatientService from "./service";
import WidgetUpdateUser from "../User/WidgetUpdateUser.vue";

export default {
    name: "WidgetUpdatePatient",
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
       "WidgetUpdateUser": WidgetUpdateUser
    }
}
</script>



<template>
    <div> 
    <p> Jedinstveni broj osiguranika: {{data.insuranceID}} </p>
    <WidgetUpdateUser :user="data.user.id" />
    
    </div>
</template>



<style>




</style>
