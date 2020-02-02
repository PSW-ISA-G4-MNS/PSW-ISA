<script>


// import widgets for this view here

export default {
    name: "VacationRequestList",
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
<router-link to="/vrm/create">New Vacation Request<router-link>
<p>Vacation Requests</p>
</div>
</template>

<style scoped> 



</style>
