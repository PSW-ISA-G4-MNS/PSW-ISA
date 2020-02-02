<script>


//import widgets for this view here

import MultiClinic from '../widgets/Clinic/multi-Clinic.vue';

export default {
    name: "ClinicList",
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
    	"multi-Clinic": MultiClinic
    }
}
</script>

<template>
<div>
    <input type="text" class="form-control" placeholder="Type name"  v-model="data.nameSearch" style="width:250px;"/>
       

    <multi-Clinic v-if = "this.data.nameSearch !== '' && this.data.nameSearch !== undefined"" :filter = "x => x.name.includes(this.data.nameSearch)"/>
    <multi-Clinic v-if = "this.data.nameSearch === ''" />
    <multi-Clinic v-if = "this.data.nameSearch === undefined" />
</div>

</template>

<style scoped> 



</style>
