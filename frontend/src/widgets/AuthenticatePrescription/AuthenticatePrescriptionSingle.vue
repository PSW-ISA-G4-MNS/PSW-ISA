<script>


export default {
	name: "AuthenticatePrescriptionSingle",
	props: ["Authenticationrequest"],
    data: function () {
        return {
          	data: {},
		success: false

        };
    },
    methods: function() {
	
    
    }
  
	
}
</script>

<template>
    

    
    <tr>
      <td id="patient">{{	Authenticationrequest.patient.insuranceID}}</td>
      <td id="ime">{{ 	Authenticationrequest.patient.user.firstname }}</td>
      <td id="prezime">{{ Authenticationrequest.patient.user.lastname}}</td>
      <td id="prescriptions"><p :key="medicineSingle.id" :id="medicineSingle.id" v-for="(medicineSingle) in this.Authenticationrequest.prescription.medicines">{{medicineSingle.medicine}}</p></td>

      
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
