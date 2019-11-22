<script>
import RegistrationRequestService from "./service";

export default {
	name: "RegistrationRequest",
	props: ["request"],
    data: function () {
        return {
          	registrationrequest: {}

        };
    },
    methods: {
    	accept: function() 
	{
		RegistrationRequestService.accept(this.request).then(response => {


			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	},
		decline: function() 
	{
		RegistrationRequestService.decline(this.request).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	}
	

	},
	
	mounted: function () 
    {
        RegistrationRequestService.get(this.request).then(

	response => {
		console.log(response.data);;
		this.registrationrequest = response.data;
		console.log(this.data);
	}
	);
    }
}
</script>

<template>
    <div id="tabela">

  <table  >    
    <tr>
      <td height="50" width="200">Jedinstveni broj</td>
      <td id="ime">{{ registrationrequest.patient.user.firstname }}</td>
      <td id="prezime">{{ registrationrequest.patient.user.lastname}}</td>
      <td id="dugme">
              <button v-on:click="accept" style="background-color:green;color:white;height:40px;width:200px">
              Potvrdi
              </button>
              
              <button v-on:click="decline" style="background-color:red;color:white;height:40px;width:200px">
              Odbij
              </button>
        </td>
    </tr>
    

  </table>
</div>

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

</style>
