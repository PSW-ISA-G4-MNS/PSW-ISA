<script>
import AuthenticatePrescriptionService from "./service";

export default {
	name: "AuthenticatePrescriptionSingle",
	props: ["request"],
    data: function () {
        return {
          	Authenticationrequest: {},
		success: false

        };
    },
    methods: {
    	accept: function() 
	{
		AuthenticatePrescriptionService.accept(this.request).then(response => {


			if (response.status == 200) this.success = true;
			else this.success = false;

		});
	},
		decline: function() 
	{
		AuthenticatePrescriptionService.decline(this.request).then(response => {
			if (response.status == 200) this.success = true;
			else this.success = false;

		});
	}
	

	},
	
	mounted: function () 
    {
        AuthenticatePrescriptionService.get(this.request).then(

	response => {
		console.log(response.data);;
		this.	Authenticationrequest = response.data;
		console.log(this.data);
	}
	);
    }
}
</script>

<template>
    

    
    <tr>
      <td id="patient">{{	Authenticationrequest.patient.insuranceID}}</td>
      <td id="ime">{{ 	Authenticationrequest.patient.user.firstname }}</td>
      <td id="prezime">{{ 	Authenticationrequest.patient.user.lastname}}</td>
      <td id="prescriptions">{{ Authenticationrequest.lastname}}</td>

      <td id="dugme">
              <button v-if="!success" v-on:click="accept" style="background-color:green;color:white;height:40px;width:200px">
              Potvrdi
              </button>
              
              <button v-if="!success" v-on:click="decline" style="background-color:red;color:white;height:40px;width:200px">
              Odbij
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
