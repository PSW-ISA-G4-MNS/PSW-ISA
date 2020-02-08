<script>


// import widgets for this view here
import WidgetCareMulti from "../widgets/Care/WidgetCareMulti.vue"

export default {
    name: "CareList",
    data: function () {
        return {
		    data: {},
            role: localStorage.getItem("role")
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
    	"WidgetCareMulti": WidgetCareMulti
    }
}
</script>

<template>

<WidgetCareMulti v-if="this.role == 'PATIENT'" all="false" :filter="x => x.patient == null"/>
<WidgetCareMulti v-else  :filter="x => x.room == null || x.doctor == null"/>

</template>

<style scoped> 



</style>
