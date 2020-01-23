<script>
import CareTypeFormService from "./service";

export default {
    name: "CareTypeForm",
    data: function () {
        return {
            data: {
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		CareTypeFormService.create(this.data).then(response => {
			this.$router.push("/");
		});
	}
    }
}
</script>

<template>
    <div class="form-CareTypeForm"> 
        <div class="success-box" v-if="success">Care type added</div>
	<div v-if="!success"> 
		
		
		<p>
		<input type="text" class="form-control" placeholder="Name of care type" v-model="data.name" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

.form-CareTypeForm {

}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
