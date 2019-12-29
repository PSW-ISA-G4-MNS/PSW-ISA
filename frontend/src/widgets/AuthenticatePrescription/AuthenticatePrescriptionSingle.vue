<script>
import AuthenticatePrescriptionService from "./service";

export default {
	name: "AuthenticatePrescriptionSingle",
	props: ["Authenticationrequest"],
    data: function () {
        return {
          	data: {},
		success: false

        };
    },
    methods: {
	
    accept: function() 
	{
		AuthenticatePrescriptionService.accept(this.Authenticationrequest.id).then(response => {
      
      if (response.status == 200) this.success = true;
			else this.success = false;


		});
	}
    
    }
	
}
</script>

<template>
    

    
    <tr>
     <td id="patient">{{	/*Authenticationrequest.patient.insuranceID*/}}</td>
      <td id="ime">{{ /*	Authenticationrequest.patient.user.firstname*/ }}</td>
      <td id="prezime">{{ /*Authenticationrequest.patient.user.lastname*/}}</td>
      <td id="prescriptions"><p :key="medicineSingle.id" :id="medicineSingle.id" v-for="(medicineSingle) in this.Authenticationrequest.prescription.medicines">{{medicineSingle.medicine}}, </p></td>
      <td id="dugme">
              <button v-if="!success" @click="accept" style="background-color:green;color:white;height:40px;width:200px">
              Accept
              </button>
              
              <button v-if="!success" style="background-color:red;color:white;height:40px;width:200px">
              Decline
              </button>
        </td>  
      
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
