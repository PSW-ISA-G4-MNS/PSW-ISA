<script>


// import widgets for this view here
import WidgetPatientMultiNurse from "../widgets/Patient/WidgetPatientMultiNurse.vue"

export default {
    name: "AllPatientsView",
    data: function () {
            return {
        data: {
            nameSearch:"",
        idSearch:""
        },
        
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
<input type="text" placeholder="Type patient id" v-model="data.idSearch" style="width:250px;"/>      


<WidgetPatientMultiNurse  :filter = "x => ((x.user.firstname + ' ' + x.user.lastname).includes(this.data.nameSearch)) && (x.insuranceID).includes(this.data.idSearch)"/>
  


</div>
</template>

<style scoped> 



</style>
