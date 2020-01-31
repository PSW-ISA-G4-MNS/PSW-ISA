<script>
import RegistrationRequestService from "./service";

export default {
	name: "RegistrationRequest",
	props: ["request"],
    data: function () {
        return {
            registrationrequest: {},
            declineResponse:{},
		        success: false,
            Dresponse: false
        };
    },
    methods: {
    	accept: function() 
	{
		RegistrationRequestService.accept(this.request.id).then(response => {

        this.declineResponse.to=this.request.patient.user.email;
        this.declineResponse.subject="Prihvacen zahtev za registraciju";
        this.declineResponse.message="Prihvacen vam je zahtev koji ste podneli za koriscenje sajta klinike"

      if (response.status == 200){ 
        this.success = true;
        
        RegistrationRequestService.email(this.declineResponse);
        
      }
			else this.success = false;

		});
  },

  reject: function() 
	{
	
   this.Dresponse=true;
   this.success = true;

  },

		email: function() 
	{
		RegistrationRequestService.email(this.declineResponse).then(response => {
			if (response.status == 200) this.Dresponse = false;
      else this.Dresponse = true;
      
      console.log("poslalo se");
    
   
		});
  },
  
  	decline: function() 
	{
		RegistrationRequestService.decline(this.request.id).then(response => {
			if (response.status == 200) this.Dresponse = false;
			else this.Dresponse = true;
    
      RegistrationRequestService.email(this.declineResponse);
		});
	}
	

	},
	
	mounted: function () 
    {
      
  this.declineResponse.to=this.request.patient.user.email;
  this.declineResponse.subject="Odbijenica za registraciju klinike";
  

    }
}
</script>

<template>
    

    
    <tr>
      <td id="insurance">{{this.request.patient.insuranceID}}</td>
      <td id="ime">{{ this.request.patient.user.firstname }}</td>
      <td id="prezime">{{ this.request.patient.user.lastname}}</td>
      <td id="dugme">
              <button v-if="!success" v-on:click="accept" style="background-color:green;color:white;height:40px;width:200px">
              Potvrdi
              </button>
              
              <button v-if="!success" v-on:click="reject" style="background-color:red;color:white;height:40px;width:200px">
              Odbij
              </button>

              
        </td>

        <td v-if="this.Dresponse">
          <p>
		        <input v-if="this.Dresponse" type="text" class="form-control" placeholder="Type reason " v-model="declineResponse.message" />
		      </p>

          <button v-if="this.Dresponse" v-on:click="decline"  style="background-color:blue;color:white;height:40px;width:200px">
              Send
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
