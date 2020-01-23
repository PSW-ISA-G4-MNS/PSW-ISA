<script>


// import widgets for this view here
import WidgetCareTypeMulti from "../widgets/CareType/multi-CareType.vue"
import WidgetCareTypeForm from "../widgets/CareType/CareTypeForm.vue"

export default {
    name: "CareTypeList",
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    },
    methods: {
    },
    components: {
    	WidgetCareTypeMulti,
	WidgetCareTypeForm
    }
}
</script>

<template>

<div>
<WidgetCareTypeForm />

<WidgetCareTypeMulti />
</div>
</template>

<style scoped> 



</style>
