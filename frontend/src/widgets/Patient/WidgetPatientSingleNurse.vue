<script>

import PatientService from "./service";

export default {
    name: "WidgetPatientSingleNurse",
    props: ["patient"],
    data: function(){
        return{
            data: {}
        }
    },
    mounted: function()
    {
  
    },
    
}
</script>



<template>
   
    
     <tr>
      <td id="insurance"><router-link :to="'/patients/' + patient.id">{{patient.insuranceID}}</router-link></td>
      <td id="ime">{{ patient.user.firstname }}</td>
      <td id="prezime">{{patient.user.lastname}}</td>
      
    </tr>
    
   
</template>



<style scoped>

table,td {
   border: 1px solid black;
  border-collapse: collapse;

}
td{
  width: 200px;
  height: 80px;
 
  
}
tr{
  width: 200px;
  height: 80px;
}
</style>
