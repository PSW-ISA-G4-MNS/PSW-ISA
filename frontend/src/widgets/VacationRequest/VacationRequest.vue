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
      },
      accept: function() {
        this.data.approved = true;
        this.data.processed = true;
        VacationRequestService.update(this.data.id, this.data).then(response => {

        });

      },
      decline: function() {
          this.data.processed = true; 
          this.data.approved = false;
          VacationRequestService.update(this.data.id, this.data).then(response => {

        });
      }
    }
}
</script>

<template>
    <div class="widget-VacationRequest"> 
    <span class="badge badge-pill badge-info">Vacation Request</span>

    <div class="card" style="width: 18rem;">
      <div class="card-body">
        <h5 class="card-title">From: {{ data.user.firstname }} {{ data.user.lastname }}</h5>
        <input 
          type="text" 
          v-model="data.commentFromAdministrator" 
          placeholder="Comment from administrator" 
          v-if="!this.data.processed && this.role == 'CLINIC_ADMINISTRATOR'" 
        />
        <p> Comment from approver: {{ data.commentFromAdministrator }}</p>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item"></li>
     </ul>


    <div class="card-body">
      <button class="btn btn-danger" @click="decline" v-if="this.role == 'CLINIC_ADMINISTRATOR' && !this.data.processed">Decline</button>
      <button class="btn btn-primary" @click="accept" v-if="this.role == 'CLINIC_ADMINISTRATOR' && !this.data.processed">Approove</button>
    </div>
    </div>
    </div>

</template>

<style scoped> 



</style>
