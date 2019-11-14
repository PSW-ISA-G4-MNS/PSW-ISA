<script>
import RegistrationRequest from "./service";

export default {
	name: "RegistrationRequest",
	props: ["request"],
    data: function () {
        return {
          

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
	

	}
	
	
}
</script>

<template>
    <div id="tabela">

  <table  >    
    <tr>
      <td height="50" width="200">Jedinstveni broj</td>
      <td id="ime">Ime</td>
      <td id="prezime">Prezime</td>
      <td id="grad">Grad</td>
      <td id="drzava">Drzava</td>
      <td id="adresa">Adresa</td>
      <td id="broj">Broj telefona</td>
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
