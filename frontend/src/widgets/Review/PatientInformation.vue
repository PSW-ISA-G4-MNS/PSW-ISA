<script>
import ReviewService from "./service";


export default {
	name: "PatientInformation",
	props: ["medicalRecord"],
    data: function () {
        return {
            data: {
		},
		recordDTO:{},
		success: false,
		
        };
    },
    mounted: function() {
		

    },
    methods: {
    	change: function() 
	{
		ReviewService.change(this.medicalRecord).then(response => {
		this.success=true;

		});
	},

	
		}
}
</script>

<template>
    <div class="formInformation"> 

		


     <p> Height
		<input type="text" class="form-control" placeholder="Height"  v-model="medicalRecord.height" />
		</p>
		
		<p>Width
		<input type="text" class="form-control" placeholder="Weight" v-model="medicalRecord.width" />
		</p>
		
		<p>Blood Type
		<input type="text" class="form-control" placeholder="Blood type" v-model="medicalRecord.bloodType" />
		</p>
		
		
		<p>Diopter
		<input type="text" class="form-control" placeholder="Diopter" v-model="medicalRecord.diopter" />
		</p>
		
		<p v-if="success">Data changed successfully!</p>
		
		<button  v-if="!success"   v-on:click="change" style="background-color:red;color:white;height:40px;width:200px">
              Confirm change
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

