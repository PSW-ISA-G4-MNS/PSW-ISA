<script>
import RegistrationRequestService from "./service";

export default {
	name: "DeclineRegistrationRequest",
	props: ["request"],
    data: function () {
        return {
          	registrationrequest: {},
		success: false

        };
    },
    methods: {
    	
		sentResponse: function() 
	{
		RegistrationRequestService.sentResponse(this.request).then(response => {
			if (response.status == 200) {
				this.data = {};
				alert("Success!");
      }
		});
	}
	

	}
	
	
}
</script>

<template>
    <div id="decline">

    <p>
		<input type="text" class="form-control" placeholder="Description" v-model="data.description" />
		</p>

    <button v-if="!success" v-on:click="sentResponse" style="background-color:blue;color:white;height:40px;width:200px">
     Posalji
    </button>
              
             
      
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
