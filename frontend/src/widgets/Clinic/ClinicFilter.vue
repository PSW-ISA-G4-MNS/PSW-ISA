<script>
import CareTypeService from "../CareType/service";

export default {
    name: "ClinicFilter",
    data: function () {
        return {
            data: {
	    },
	    careTypes: [],
	    success: false
        };
    },
    mounted: function() {
    	CareTypeService.list().then(response => {
		this.careTypes = response.data; 
	});
    },
    methods: {
    	submit: function() 
	{
		CareTypeService.submit(this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;
		});
	},
	selectCareType: function(index) {
		console.log("Called with id = " + index);
		this.data.careTypeId = this.careTypes[index].id;
	}
    }
}
</script>

<template>
    <div class="form-CareForm"> 
        <div class="success-box" v-if="success">Care created</div>
	<div v-if="!success"> 
		
		<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonCareType" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select care type
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonCareType">
		    <a :key="careType.id" :id="careType.id" @click="selectCareType(index)" v-for="(careType, index) in this.careTypes" class="dropdown-item" href="#">{{ careType.name }}</a>
		  </div>
		</div>

		<p>
		<input type="datetimet" class="form-control" placeholder="Start" v-model="data.startTime" />
		</p>


		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 
.form-CareForm {
}
.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}
</style>