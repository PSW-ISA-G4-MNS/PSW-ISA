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
<div class="form">

<input type="text"  placeholder="Type name"  v-model="data.nameSearch" />
<input type="text" placeholder="Type patient id" v-model="data.idSearch"/>      


<WidgetPatientMultiNurse  :filter = "x => ((x.user.firstname + ' ' + x.user.lastname).includes(this.data.nameSearch)) && (x.insuranceID).includes(this.data.idSearch)"/>
  


</div>
</template>

<style scoped> 
.form {
position:relative;
    top:20%;
    left:20%;
	padding: 40px; 
	margin: 40px;
	text-align: center;
	width: 60%;
}

input{
width: 50%;
  padding: 12px 20px;
  
  box-sizing: border-box;
}

</style>
