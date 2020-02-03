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
		
		medicalRecordObj:{},
		medicalId:0,
		
        };
	},
	components: {
		"Review": Review,
		"PatientInformation":PatientInformation
    },

    mounted: function() {
	
	ReviewService.getMedicalRecord(this.patientId).then(response => {
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
    <div> 
		
		<PatientInformation
		 style="float:left;"
		
		:medicalRecord="this.medicalRecordObj"/>
		
		 <Review style="float:left;"
		 :id="medicalRecordObj.id"
		 :key="medicalRecordObj.id"
		 :medicalRecordId="this.medicalRecordObj.id"
		 :careId="this.careId"
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

