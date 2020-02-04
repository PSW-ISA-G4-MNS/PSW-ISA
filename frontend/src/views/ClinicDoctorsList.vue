<script>


// import widgets for this view here
import WidgetDoctorMulti from "../widgets/Doctor/WidgetDoctorMulti.vue"

export default {
    name: "ClinicDoctorsList",
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
    	"WidgetDoctorMulti": WidgetDoctorMulti
    }
}
</script>

<template>
<div>
    <input type="text" class="form-control" placeholder="Type name"  v-model="data.nameSearch" style="width:250px;"/>

    <WidgetDoctorMulti v-if = "this.data.nameSearch !== '' && this.data.nameSearch !== undefined" :filter = "x => (x.user.firstname + ' ' + x.user.lastname).match(this.data.nameSearch)"/>
    <WidgetDoctorMulti v-if = "this.data.nameSearch === ''"/>
    <WidgetDoctorMulti v-if = "this.data.nameSearch === undefined"/>

</div>
</template>

<style scoped> 



</style>
