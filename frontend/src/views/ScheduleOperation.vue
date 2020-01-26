<script>


// import widgets for this view here

export default {
    name: "ScheduleOperation",
    data: function () {
            return {
		data: {},
		role: localStorage.getItem("role"),
		user: localStorage.getItem("user_id"),
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
    }
}
</script>

<template>
<div class="scheduling">
<p>Schedule operation</p>
</div>
</template>

<style scoped> 



</style>
