<script>
import ReviewService from "./service";
import MedicineService from "../Medicine/service";
import DiagnosisService from "../Diagnosis/service";

export default {
	name: "ReviewForm",
	props: ["Review"],
    data: function () {
        return {
            data: {
	    },
	    medicines: [],
		allDiagnosis:[],
	    success: false

        };
    },
    mounted: function() {
    	MedicineService.list().then(response => {
		this.medicines = response.data; 
	});
    	DiagnosisService.list().then(response => {
		this.allDiagnosis = response.data; 
	});

		
        ReviewService.getReview(this.Review).then(response => this.data = response.data);
		
    },
    methods: {
    	submit: function() 
	{
		ReviewService.submit(this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	},
	selectMedicine: function(index) {
		console.log("Called with id = " + index);
		newMedicine=this.medicines[index].id;
		this.data.prescription.push(newMedicine);
	},
	selectDiagnosis: function(index) {
		console.log("Called with id = " + index);
		this.data.diagnosis=allDiagnosis[index].id
	}
    }
}
</script>

<template>
    <div class="form-CareForm"> 
        <div class="success-box" v-if="success">Review Started</div>
	<div v-if="!success"> 
		
		<p>
		<input type="text" class="form-control" placeholder="Report" v-model="data.comment" />
		</p>

		<div class="dropdown">
		  
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonMedicine">
		    <a :key="medicine.id" :id="medicine.id" @click="selectMedicine(index)" v-for="(medicine, index) in this.medicines" class="dropdown-item" href="#">{{ medicine.medicine }}</a>
		  </div>
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonDiagnosis" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select medicine
		  </button>
		</div>
		
		<div class="dropdown">
		  
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonDiagnosis">
		    <a :key="diagnosis.id" :id="diagnosis.id" @click="selectDiagnosis(index)" v-for="(diagnosis, index) in this.allDiagnosis" class="dropdown-item" href="#">All Diagnosis: {{ diagnosis.diagnosis}}</a>
		  </div>
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonDiagnosis" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select diagnosis
		  </button>
		</div>
		
	
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 



.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
