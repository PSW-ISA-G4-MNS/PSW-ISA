<script>
import RoomFormService from "./service";

export default {
    name: "RoomForm",
    data: function () {
        return {
            data: {
	    	clinicId: null,
		id: null
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		RoomFormService.create(this.data).then(response => {
			this.data = {};
		});
	}
    }
}
</script>

<template>
    <div class="form-RoomForm"> 
        <div class="success-box" v-if="success"></div>
	<div v-if="!success"> 
		
		
		<p>
		<input type="text" class="form-control" placeholder="Title" v-model="data.title" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="Capacity" v-model="data.capacity" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

.form-RoomForm {

}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
