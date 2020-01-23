<script>
import OldReviewChangeService from "./service";
import MedicineService from "../Medicine/service";
import DiagnosisService from "../Diagnosis/service";

export default {
	name: "ReviewForm",
	props: ["Review","medicalRecordId"],
    data: function () {
        return {
            data: {
		},
		Care:{},
		oldReviewSelected:0,
		allMedicines: [],
		Prescription:{},
		medicinesForPrescription:[],
		allDiagnosis: [],
	    success: false,
		idOfPrescription:0,
        };
    },
	mounted:
	
	function() {
    	MedicineService.list().then(response => {
		this.allMedicines = response.data; 
	});
    	DiagnosisService.list().then(response => {
		this.allDiagnosis = response.data; 
	});
//, citace samo id,  koji ce da se nalazi u Review
//ovo se stavi >>>>>
//this.data.careID=Review;
   

		this.Prescription.medicines=this.medicinesForPrescription;
		
		

		this.oldReviewSelected=localStorage.getItem('oldReviewSelected');

		OldReviewChangeService .getOld(this.oldReviewSelected).then(response =>{
			this.Care= response.data;
			this.data.comment=response.data.comment;
			this.data.careId=1;
			this.Prescription.id=response.data.prescription.id;
		});
	

		
    },
    methods: {
    	submit: function() 
	{
		 OldReviewChangeService.submit(this.data).then(response => {
			alert("Review is changed!");

		});
	},

		accept: function() 
	{
		 OldReviewChangeService.accept(this.Prescription).then(response => {
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
	//	this.Prescription.medicines=this.medicinesForPrescription;
		
		
	},
	selectDiagnosis: function(index) {
		console.log("Called with id = " + index);
		this.data.diagnosisId=this.allDiagnosis[index].id;
		$("#dropdownMenuDiagnosisButton").html(this.allDiagnosis[index].diagnosis);
		
	}
    }
}
</script>

<template>
    <div class="form"> 
        <div class="success-box" v-if="success">Review Started</div>
	<div v-if="!success"> 
		
		<p>
		<input type="text" class="form-control" placeholder="Report" v-model="this.Care.comment" />
		</p>

		<div class="dropdown">
		  
		  <div class="dropdown-menu" aria-labelledby="dropdownMedicine">
		    <a :key="medicine.id" :id="medicine.id" @click="selectMedicine(index)" v-for="(medicine, index) in this.allMedicines" class="dropdown-item" href="#">{{ medicine.medicine }}</a>
		  </div>
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuMedicineButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select medicine
		  </button>
		</div>

		<div>
		<table v-if="this.Care.prescription.medicines.length!=0" style="float:left;">
			<tr>
				<th>Old Prescription</th>
			</tr>

			<tr>
				<th v-for="item in this.Care.prescription.medicines"
				:id="item"
      			:key="item.medicine">

				{{item.medicine}}

				</th>


				
			</tr>
		</table>


		<table >
			<tr>
				<th>New Prescription</th>
			</tr>

			<tr>
				<th v-for="item in this.medicinesForPrescription"
				:id="item"
      			:key="item.medicine">

				{{item.medicine}}

				</th>


				
			</tr>
		</table>
		</div>
	
	<button type="button" @click="accept" style="background-color:green;color:white;height:40px;width:200px">Confirm  prescription</button>
		


		<div class="dropdown">
		  
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuDiagnosis">
		    <a :key="diagnosisSingle.id" :id="diagnosisSingle.id" @click="selectDiagnosis(index)" v-for="(diagnosisSingle, index) in this.allDiagnosis" class="dropdown-item" href="#"> {{ diagnosisSingle.diagnosis}}</a>
		  </div>
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuDiagnosisButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    {{this.Care.diagnosis.diagnosis}}
		  </button>
		</div>
		
	
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Coplete the review</button>
	</div>
    </div>

</template>

<style scoped> 


.form {
position:relative;
    top:10%;
    left:20%;
	padding: 40px; 
	margin: 40px;
	text-align: center;
	width: 60%;
}

.success-box 
{
	background-color: #dfd;
	color: #0f0;
	padding: 5px;
}

table,td,tr,th {
   border: 1px solid black;
  border-collapse: collapse;

}
td,th{
  width: 150px;
  height: 40px;
}

</style>
