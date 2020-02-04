<script>
import VacationRequestFormService from "./service";

export default {
    name: "VacationRequestForm",
    data: function () {
        return {
            data: {
	    	approved: false,
		type: null,
		commentFromAdministrator: "",
		user: null
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		VacationRequestFormService.create(this.data).then(response => {
			this.data.startTime = null,
			this.data.endTime = null;
			this.data.commentFromUser = "";
			this.$emit("submit");

		});
	}
    }
}
</script>

<template>
    <div class="form-VacationRequestForm"> 
	<div > 
		
		
		<p>
		<input type="date" class="form-control" placeholder="Starts" v-model="data.startTime" />
		</p>
		
		<p>
		<input type="date" class="form-control" placeholder="Ends" v-model="data.endTime" />
		</p>
		
		<p>
		<input type="text" class="form-control" placeholder="Comment" v-model="data.commentFromUser" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

.form-VacationRequestForm {

}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
