<script>


// import widgets for this view here
import WidgetUserSingle from "../widgets/User/WidgetUserSingle.vue"
import WidgetPatientSingle from "../widgets/Patient/WidgetPatientSingle.vue"
import PatientService from "../widgets/Patient/service"

export default {
    name: "Profile",
    data: function () {
            return {
		data: {
            id: null
        },
		role: localStorage.getItem("role"),
		user: localStorage.getItem("user_id")
	    };
	},
    mounted: function () 
    {
        if (this.role == "PATIENT") {
            PatientService.get().then(response => {
                this.data = response.data;
            });
        }
    },
    methods: {
        submit: function (event) 
        {
            
        }
    },
    components: {
    	WidgetPatientSingle,
	WidgetUserSingle
    }
}
</script>

<template>

<div>

<p class="p">
<WidgetPatientSingle v-if="this.role == 'PATIENT' && this.data.id != null" :patient="data.id"/>
<WidgetUserSingle v-else :user="this.user" />
</p>
</div>
</template>


<style scoped> 
.p{
    position:fixed;
    top:20%;
    left:40%;
	padding: 10px; 
	margin: 10px;
	text-align: center;
	width: 20%;
}


</style>
