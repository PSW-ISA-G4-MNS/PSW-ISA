<script>
import ClinicService from "./service";

export default {
    name: "ClinicReport",
    props: ["ClinicReport"],
    data: function () {
        return {
            data: {},
	    clinic: {},
	    reportAvailable: false
        }
    },
    mounted: function () 
    {
        ClinicService.report(this.ClinicReport).then(response => {
		this.data = response.data
		this.reportAvailable = true;
	});
        ClinicService.get(this.ClinicReport).then(response => this.clinic = response.data);
    },
    methods: 
    {
    }
}
</script>

<template>
    <div v-if="this.reportAvailable" class="widget-ClinicReport"> 
    <span class="badge badge-pill badge-info">ClinicReport: </span>

    <div class="card" style="width: 18rem;">
      <p>TOP</p>
      <div class="card-body">
        <h5 class="card-title"></h5>
        <p class="card-text item-description"></p>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item">Revenue: {{ data.revenue }}</li>
        <li class="list-group-item">Number of performed cares last day: {{ data.careCountLastDay }}</li>
        <li class="list-group-item">Number of performed cares last week: {{ data.careCountLastWeek }}</li>
        <li class="list-group-item">Number of performed cares last month: {{ data.careCountLastMonth }}</li>
        <li class="list-group-item">Average Rating: {{ data.averageRating }}</li>
     </ul>


    <div class="card-body">
    </div>
    </div>
    </div>

</template>

<style scoped> 



</style>
