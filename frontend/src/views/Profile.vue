<script>


// import widgets for this view here
import WidgetUserSingle from "../widgets/User/WidgetUserSingle.vue"
import WidgetPatientSingle from "../widgets/Patient/WidgetPatientSingle.vue"

export default {
    name: "Profile",
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
    	"WidgetPatientSingle": WidgetPatientSingle
    }
}
</script>

<template>

<div>

<p class="p">
<WidgetPatientSingle/>
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
