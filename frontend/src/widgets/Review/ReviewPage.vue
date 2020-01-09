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
		patientIdTest:1,
		medicalRecordObj:null,
		medicalId:0,
		
        };
	},
	components: {
		"Review": Review,
		"PatientInformation":PatientInformation
    },

    mounted: function() {
	
	ReviewService.getMedicalRecord(this.patientIdTest).then(response => {
			this.medicalRecordObj=response.data;
			this.medicalId=response.data.id;
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
		:medicalRecord="medicalRecordObj"/>
		
		 <Review
		 :medicalRecordId="medicalId"
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

