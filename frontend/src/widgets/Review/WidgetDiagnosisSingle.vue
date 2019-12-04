<script>
import ReviewService from "./service";

export default {
    name: "WidgetDiagnosisSingle",
    props: ["request"],
    data: function () {
        return {
          
                dijagnoza: {}
        };
    },
    methods: {
    
	

	},
	
	mounted: function () 
    {
       RewiewService.getDiagnosis(this.request).then(response => {
		
		this.dijagnoza = response.data;
		
    }
	);
    }
}
</script>

<template>
    
    <b-dropdown-item id={{dijagnoza.diagnosis}} > 
	{{dijagnoza.diagnosis}}
  </b-dropdown-item>
		


</template>

<style scoped> 



</style>
