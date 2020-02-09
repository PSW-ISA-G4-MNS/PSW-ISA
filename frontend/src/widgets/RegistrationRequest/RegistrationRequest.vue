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
            Dresponse: false,
            returnResponse:{}
        };
    },
    methods: {
    	accept: function() 
	{
		RegistrationRequestService.accept(this.request.id).then(response => {

        

      if (response.status == 200){ 
        this.success = true;
        

        
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
		
  },
  
  	decline: function() 
	{
		RegistrationRequestService.decline(this.returnResponse).then(response => {
			if (response.status == 200) this.Dresponse = false;
			else this.Dresponse = true;
    
     
		});
	}
	

	},
	
	mounted: function () 
    {
      
      this.returnResponse.id=this.request.id;
  

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
		        <input v-if="this.Dresponse" type="text" class="form-control" placeholder="Type reason " v-model="returnResponse.comment" />
		      </p>

          <button v-if="this.Dresponse" v-on:click="decline"  style="background-color:blue;color:white;height:40px;width:200px">
              Send
              </button>
        </td>
    </tr>
    

  


</template>

<style scoped> 

input{
width: 50%;
  padding: 12px 20px;
  
  box-sizing: border-box;
}

td{
  width: 200px;
  height: 50px;
 background-color: #f9f9f9;
  
}
tr{
  width: 200px;
  height: 50px;
  min-width: 120px;
  padding: 10px 20px;
}

body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #42b983;
  border-radius: 3px;
  background-color: #fff;
}

th {
  background-color: #42b983;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}



th.active {
  color: #fff;
}

th.active .arrow {
  opacity: 1;
}

.arrow {
  display: inline-block;
  vertical-align: middle;
  width: 0;
  height: 0;
  margin-left: 5px;
  opacity: 0.66;
}

.arrow.asc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-bottom: 4px solid #fff;
}

.arrow.dsc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-top: 4px solid #fff;
}

</style>
