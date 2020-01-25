<script>


//import widgets for this view here

import MultiClinicReport from '../widgets/Clinic/multi-ClinicReport.vue';
import MultiRoom from '../widgets/Room/multi-Room.vue';
import RoomForm from '../widgets/Room/RoomForm.vue';
import DoctorNew from '../widgets/Doctor/DoctorNew.vue';
import MultiDoctor from '../widgets/Doctor/multi-ClinicDoctor.vue';

export default {
    name: "ClinicReportView",
    data: function () {
            return {
		data: {},
		addDoctor: false
	    };
	},
    mounted: function () 
    {
    },
    methods: {
        submit: function (event) 
        {
            
        },
	addDoctorClicked: function() {
		this.addDoctor = ! this.addDoctor;
	}
    },
    components: {
    	"multi-ClinicReport": MultiClinicReport,
	"multi-Room": MultiRoom,
	"RoomForm": RoomForm,
	"DoctorNew": DoctorNew,
	"MultiDoctor": MultiDoctor
    }
}
</script>

<template>
<div id="my-clinic-view">
<p>Add new room</p>
<RoomForm />

<multi-ClinicReport />

<multi-Room />


<button @click="addDoctorClicked">Add New Doctor</button>
<DoctorNew v-if="this.addDoctor" />

<MultiDoctor />

</div>
</template>

<style scoped> 



</style>
