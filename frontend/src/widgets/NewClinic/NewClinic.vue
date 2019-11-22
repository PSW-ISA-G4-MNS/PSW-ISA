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

		});
	}
    }
}
</script>

<template>
    <div class="form-NewClinic"> 
        <div class="success-box" ></div>
		
		
		<p>
		<input type="text" class="form-control" placeholder="ID" v-model="data.id" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="LocationLat" v-model="data.LocationLat" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="LocationLog" v-model="data.LocationLog" />
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

table,td {
   border: 1px solid black;
  border-collapse: collapse;

}
td{
  width: 200px;
  height: 80px;
}

</style>
