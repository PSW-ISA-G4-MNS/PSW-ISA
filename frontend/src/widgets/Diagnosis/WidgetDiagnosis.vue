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

</style>
