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
        PatientService.getSingle(this.patient).then(

	response => {
		
		this.data = response.data;
		
	})
    },
    
}
</script>



<template>
   
    
     <tr>
      <td id="insurance">{{data.insuranceID}}</td>
      <td id="ime">{{ data.user.firstname }}</td>
      <td id="prezime">{{data.user.lastname}}</td>
      
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
