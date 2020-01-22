<script>
import ReviewService from "./service";
import Review from "./Review.vue";
import PatientInformation from "./PatientInformation.vue";


export default {
	name: "ReviewPage",
	props: ["patientId","careId"],
    data: function () {
        return {
            data: {
		},
		patientIdTest:0,
		medicalRecordObj:{},
		medicalId:0,
		
        };
	},
	components: {
		"Review": Review,
		"PatientInformation":PatientInformation
    },

    mounted: function() {
	this.patientIdTest=2;
	

	ReviewService.getMedicalRecord(1).then(response => {
			this.medicalRecordObj=response.data;
			
		});

		
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
    <div class="form" > 
		
		<PatientInformation style="float:left;"
		
		:medicalRecord="this.medicalRecordObj"/>
		
		 <Review
		 :id="medicalRecordObj.id"
		 :key="medicalRecordObj.id"
		 :medicalRecordId="this.medicalRecordObj.id"
		 />
		
		
		
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

