<script>
import CareTypeService from "./service";

export default {
    name: "CareType",
    props: ["CareType"],
    data: function () {
        return {
            data: {},
	    deleted: false
        }
    },
    mounted: function () 
    {
        CareTypeService.get(this.CareType).then(response => this.data = response.data);
    },
    methods: 
    {
    	deleteItem: function() 
	{
		CareTypeService.delete(this.CareType).then(response => {
			this.data = {}
			this.deleted = true;
		});
	}
	// add additional methods here
    }
}
</script>

<template>
    <div v-if="!this.deleted" class="widget-CareType"> 
    <span class="badge badge-pill badge-info">CareType: </span>

    <div class="card" style="width: 18rem;">
      <p>{{ data.name }}</p>
      <div class="card-body">
        <h5 class="card-title"></h5>
        <p class="card-text item-description"></p>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item"></li>
     </ul>


    <div class="card-body">
      <button class="btn btn-danger" @click="deleteItem" v-if="true">Delete</button>
    </div>
    </div>
    </div>

</template>

<style scoped> 



</style>
