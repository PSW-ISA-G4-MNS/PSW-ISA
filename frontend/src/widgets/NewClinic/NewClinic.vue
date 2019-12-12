<script>
import NewClinicService from "./service";

export default {
	name: "NewClinic",
	props: ["request"],
     data: function () {
        return {
            data: {

	    },

        };
    },
    methods: {
    	submit: function() 
	{
		NewClinicService.submit(this.data).then(response => {
			if (response.status == 200) {
				this.data = {};
				alert("Success!");
			}
		});
	}
    }
}
</script>

<template>
    <div class="form-NewClinic"> 
        <div class="success-box" ></div>
		
		<h2>Create Clinic</h2>
		
		<p>
		<input type="number" class="form-control" placeholder="LocationLat" v-model="data.locationLat" />
		</p>
		
		<p>
		<input type="number" class="form-control" placeholder="LocationLog" v-model="data.locationLon" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="Name" v-model="data.name" />
		</p>
		
		<p>
		<input type="email" class="form-control" placeholder="Address" v-model="data.address" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="Description" v-model="data.description" />
		</p>
		
		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>

 

</template>

<style scoped> 

.form-NewClinic {
	position:fixed;
    top:20%;
    left:40%;
	padding: 10px; 
	margin: 10px;
	text-align: center;
	width: 20%;
}

.success-box 
{
	
	padding: 5px;
}

</style>
