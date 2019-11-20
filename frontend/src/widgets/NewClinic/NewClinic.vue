<script>


export default {
	name: "NewClinic",
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
		

	},
	
	mounted: function () 
    {
        RegistrationRequestService.get(this.request).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div id="tabela">

 
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
