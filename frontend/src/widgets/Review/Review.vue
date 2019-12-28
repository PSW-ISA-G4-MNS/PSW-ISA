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
		allMedicines: [],
		Prescription:{},
		medicinesForPrescription:[],
		allDiagnosis: [],
	    success: false,
		idOfPrescription:0,
        };
    },
    mounted: function() {
    	MedicineService.list().then(response => {
		this.allMedicines = response.data; 
	});
    	DiagnosisService.list().then(response => {
		this.allDiagnosis = response.data; 
	});

		this.Prescription.medicines=this.medicinesForPrescription;
    //ReviewService.get(1).then(response => {this.data = response.data});
		
    },
    methods: {
    	submit: function() 
	{
		ReviewService.submit(this.data).then(response => {
			

		});
	},

		accept: function() 
	{
		ReviewService.accept(this.Prescription).then(response => {
			if (response.status == 200) {
				console.log("nice");
				this.data.prescriptionId=response.data;
			}

		});
	},
	selectMedicine: function(index) {
		console.log("Called with id = " + index);
		//this.data.medicine=this.medicines[index].id;
		 $("#dropdownMenuMedicineButton").html(this.allMedicines[index].medicine);
		 this.medicinesForPrescription.push(this.allMedicines[index]);
		this.Prescription.medicines=this.medicinesForPrescription;
		
		
	},
	selectDiagnosis: function(index) {
		console.log("Called with id = " + index);
		this.data.diagnosisId=this.allDiagnosis[index].id;
		$("#dropdownMenuDiagnosisButton").html(this.allDiagnosis[index].diagnosis);
		//this.data.diagnosis=this.allDiagnosis[index].id;
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
		  
		  <div class="dropdown-menu" aria-labelledby="dropdownMedicine">
		    <a :key="medicine.id" :id="medicine.id" @click="selectMedicine(index)" v-for="(medicine, index) in this.allMedicines" class="dropdown-item" href="#">{{ medicine.medicine }}</a>
		  </div>
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuMedicineButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select medicine
		  </button>
		</div>
		<button type="button" class="btn btn-primary btn-lg btn-block" @click="accept">Submit</button>
		
		<div class="dropdown">
		  
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuDiagnosis">
		    <a :key="diagnosisSingle.id" :id="diagnosisSingle.id" @click="selectDiagnosis(index)" v-for="(diagnosisSingle, index) in this.allDiagnosis" class="dropdown-item" href="#"> {{ diagnosisSingle.diagnosis}}</a>
		  </div>
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuDiagnosisButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
	background-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
