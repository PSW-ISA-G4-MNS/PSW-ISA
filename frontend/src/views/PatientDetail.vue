<script>



import PatientService from "../widgets/Patient/service"
import WidgetPatientSingle from "../widgets/Patient/WidgetPatientSingle.vue"


export default {
    name: "PatientDetail",
    props: ["patient"],
    data: function () {
            return {
		data: {},
	    };
	},
    mounted: function () 
    {
    },
    methods: {
    },
    components: {
        "WidgetPatientSingle": WidgetPatientSingle,
    }
}
</script>

<template>
    <div class="Patient-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetPatientSingle :patient="this.patient" />
    </div>

</template>

<style scoped> 



</style>
