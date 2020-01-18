<script>


//import widgets for this view here

import MultiClinicReport from '../widgets/Clinic/multi-ClinicReport.vue';
import MultiRoom from '../widgets/Room/multi-Room.vue';
import RoomForm from '../widgets/Room/RoomForm.vue';

export default {
    name: "ClinicReportView",
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    },
    methods: {
        submit: function (event) 
        {
            
        }
    },
    components: {
    	"multi-ClinicReport": MultiClinicReport,
	"multi-Room": MultiRoom,
	"RoomForm": RoomForm
    }
}
</script>

<template>
<div id="my-clinic-view">
<p>Add new room</p>
<RoomForm />

<multi-ClinicReport />

<multi-Room />
</div>
</template>

<style scoped> 



</style>
