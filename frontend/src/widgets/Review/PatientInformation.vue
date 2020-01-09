<script>
import ReviewService from "./service";
import MedicineService from "../Medicine/service";
import DiagnosisService from "../Diagnosis/service";

export default {
	name: "PatientInformation",
	props: ["medicalRecord"],
    data: function () {
        return {
            data: {
		},
		
        };
    },
    mounted: function() {
   this.data.height=this.medicalRecord.height;	
   this.data.width=this.medicalRecord.width;
   this.data.bloodType=this.medicalRecord.bloodType;
   this.data.diopter=this.medicalRecord.diopter;

    },
    methods: {
    	submit: function() 
	{
		ReviewService.submit(this.data).then(response => {
			

		});
	},

	
		}
}
</script>

<template>
    <div class="formInformation"> 

		


     <p> Height
		<input type="text" class="form-control" placeholder="Height" v-model="data.height" v />
		</p>
		
		<p>Width
		<input type="text" class="form-control" placeholder="Width" v-model="data.width" />
		</p>
		
		<p>Blood Type
		<input type="text" class="form-control" placeholder="Blood type" v-model="data.bloodType" />
		</p>
		
		
		<p>Diopter
		<input type="text" class="form-control" placeholder="Diopter" v-model="data.diopter" />
		</p>
		
		<button style="background-color:red;color:white;height:40px;width:200px">
              Izmeni podatke
              </button>
		
		<button style="background-color:red;color:white;height:40px;width:200px">
              Potvrdi izmenu
              </button>
    </div>

		

</template>

<style scoped> 


.form {
position:relative;
    top:20%;
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



</style>

