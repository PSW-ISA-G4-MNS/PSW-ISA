<script>
import VacationRequestService from "./service";

export default {
    name: "VacationRequest",
    props: ["VacationRequest"],
    data: function () {
        return {
            data: {},
	    role: localStorage.getItem("role")
        }
    },
    mounted: function () 
    {
        VacationRequestService.get(this.VacationRequest).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		VacationRequestService.delete(this.VacationRequest).then(response => this.data = {});
	}
	// add additional methods here
    }
}
</script>

<template>
    <div class="widget-VacationRequest"> 
    <span class="badge badge-pill badge-info">Vacation Request</span>

    <div class="card" style="width: 18rem;">
      <div class="card-body">
        <h5 class="card-title">From: {{ data.user.firstname }} {{ data.user.lastname }}</h5>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item"></li>
     </ul>


    <div class="card-body">
      <button class="btn btn-danger" @click="deleteItem" v-if="this.role == 'CLINIC_ADMINISTRATOR'">Decline</button>
      <button class="btn btn-primary" @click="data.approved = true" v-if="this.rolee == 'CLINIC_ADMINISTRATOR'">Approove</button>
    </div>
    </div>
    </div>

</template>

<style scoped> 



</style>
