<script>
import ReviewService from "./service";


export default {
	name: "PatientInformation",
	props: ["patientIdTest"],
    data: function () {
        return {
            data: {
		},
		recordDTO:{}
		
        };
    },
    mounted: function() {
  

    },
    methods: {
    	submit: function() 
	{
		
	},

	
		}
}
</script>

<template>
    <div class="formInformation"> 

		


     <p> Height
		<input type="text" class="form-control" placeholder="Height" />
		</p>
		
		<p>Width
		<input type="text" class="form-control" placeholder="Width" v-model="this.recordDTO.width" />
		</p>
		
		<p>Blood Type
		<input type="text" class="form-control" placeholder="Blood type" v-model="this.recordDTO.bloodType" />
		</p>
		
		
		<p>Diopter
		<input type="text" class="form-control" placeholder="Diopter" v-model="this.recordDTO.diopter" />
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

