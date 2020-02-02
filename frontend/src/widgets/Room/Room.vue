<script>
import RoomService from "./service";

export default {
    name: "Room",
    props: ["Room"],
    data: function () {
        return {
            data: {},
	    deleted: false,
        }
    },
    mounted: function () 
    {
        RoomService.get(this.Room).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		RoomService.delete(this.Room).then(response => {
			this.data = {};
			this.deleted = true;
		});
	},
	editItem: function () {
		this.$router.push("/roomEdit/" + this.Room);
	}
	// add additional methods here
    }
}
</script>

<template>
    <div v-if="!deleted" class="widget-Room"> 
    <span class="badge badge-pill badge-info">Room: </span>

    <div class="card" style="width: 18rem;">
      <p>Room</p>
      <div class="card-body">
        <h5 class="card-title">{{ data.title }}</h5>
        <p class="card-text item-description"></p>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item">Capacity: {{ data.capacity }}</li>
     </ul>


    <div class="card-body">
      <button class="btn btn-danger" @click="deleteItem" v-if="true">Delete</button>
      <button class="btn btn-primary" @click="editItem" v-if="true">Edit</button>
    </div>
    </div>
    </div>

</template>

<style scoped> 



</style>
