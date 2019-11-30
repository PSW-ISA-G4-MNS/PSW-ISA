<script>
import ClinicService from "./service";

export default {
    name: "Clinic",
    props: ["Clinic"],
    data: function () {
        return {
            data: {},
        }
    },
    mounted: function () 
    {
        ClinicService.get(this.Clinic).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		ClinicService.delete(this.Clinic).then(response => this.data = {});
	}
	// add additional methods here
    }
}
</script>

<template>
    <div class="widget-Clinic"> 
    <span class="badge badge-pill badge-info">Clinic: </span>

    <div class="card" style="width: 18rem;">
      <p>{{ data.name }}</p>
      <div class="card-body">
        <h5 class="card-title"></h5>
        <p class="card-text item-description"></p>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item">Description: {{data.description}}</li>
        <li class="list-group-item">Address: {{data.address}}</li>
        <li class="list-group-item">Location: {{data.LocationLat}} {{data.LocationLog}}</li>
     </ul>


    <div class="card-body">
    </div>
    </div>
    </div>

</template>

<style scoped> 



</style>
