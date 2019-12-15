<script>
import DiagnosisService from "./service";

export default {
	name: "WidgetDiagnosis",
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
		DiagnosisService.submit(this.data).then(response => {
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
    <div class="form-Dianosis"> 
        
		
		<h2>New Diagnosis</h2>
		<p>
		<input type="text" class="form-control" placeholder="NewDiagnosis" v-model="data.diagnosis" />
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

.form-Dianosis{
	position: relative;
    top:10%;
    left:40%;
	padding: 10px; 
	margin: 10px;
	text-align: center;
	width: 20%;
}

</style>
