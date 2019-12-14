<script>
import MedicineService from "./service";

export default {
	name: "WidgetMedicine",
	props: ["request"],
     data: function () {
        return {
            data: {

	    },

        };
    },
    methods: {
    	submit: function() 
	{
		MedicineService.submit(this.data).then(response => {
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
    <div class="form-NewMedicine"> 
       
		
		<p>
		<input type="text" class="form-control" placeholder="Name of the medicine" v-model="data.medicine" />
		</p>
		
		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	
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
.form-NewMedicine{
	position:fixed;
    top:10%;
    left:40%;
	padding: 10px; 
	margin: 10px;
	text-align: center;
	width: 20%;
}

</style>
