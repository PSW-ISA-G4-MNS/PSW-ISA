<script>


// import widgets for this view here
import WidgetPatientMultiNurse from "../widgets/Patient/WidgetPatientMultiNurse.vue"

export default {
    name: "AllPatientsView",
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
    	"WidgetPatientMultiNurse": WidgetPatientMultiNurse
    }
}
</script>

<template>
<div>

<input type="text" class="form-control" placeholder="Type name"  v-model="data.nameSearch" style="width:250px;"/>
<input type="number" placeholder="Type patient id" v-model="data.idSearch" style="width:250px;"/>      

    <WidgetPatientMultiNurse v-if = "this.data.nameSearch !== '' && this.data.nameSearch !== undefined " :filter = "x => ((x.user.firstname + ' ' + x.user.lastname).match(this.data.nameSearch))"/>
    <WidgetPatientMultiNurse v-if = "this.data.idSearch !== '' && this.data.idSearch !== undefined" :filter = "x => ((x.insuranceID).match(this.data.idSearch)) " />
    <WidgetPatientMultiNurse v-if = "this.data.nameSearch === ''" />
    <WidgetPatientMultiNurse v-if = "this.data.nameSearch === undefined" />


</div>
</template>

<style scoped> 



</style>
