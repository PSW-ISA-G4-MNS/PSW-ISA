<script>
import ReviewService from "./service";

export default {
    name: "WidgetDrugSingle",
    props: ["request"],
    data: function () {
        return {
          
                lek: {}
        };
    },
    methods: {
   
	

	},
	
	mounted: function () 
    {
       ReviewService.getDrugs(this.request).then(response => {
		
		this.lek = response.data;
		
    }
	);
    }
}
</script>

<template>
    
    <b-dropdown-item> 
	{{lek.medicine}}
  </b-dropdown-item>
		


</template>

<style scoped> 



</style>
