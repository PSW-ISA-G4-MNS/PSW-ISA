<script>
import DoctorService from "./service";

export default {
    name: "Doctor",
    props: ["Doctor"],
    data: function () {
        return {
            data: {},
        }
    },
    mounted: function () 
    {
        DoctorService.get(this.Doctor).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		DoctorService.delete(this.Doctor).then(response => this.data = {});
	}
	// add additional methods here
    }
}
</script>

<template>
    <div class="widget-Doctor"> 
    <span class="badge badge-pill badge-info">Doctor: </span>

    <div class="card" style="width: 18rem;">
      <p>Doctor</p>
      <div class="card-body">
        <h5 v-if="data.user != null" class="card-title">{{data.user.firstname }} {{ data.user.lastname }}</h5>
        <p class="card-text item-description"></p>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item"></li>
     </ul>


    <div class="card-body">
    </div>
    </div>
    </div>

</template>

<style scoped> 



</style>
