<script>


// import widgets for this view here
import Form from "../widgets/VacationRequest/VacationRequestForm.vue";
import List from "../widgets/VacationRequest/multi-VacationRequest.vue";


export default {
    name: "VacationRequestList",
    data: function () {
            return {
		data: {},
		role: localStorage.getItem("role"),
		user: localStorage.getItem("user_id"),
		create: false,
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
    	Form,
	List
    }
}
</script>

<template>
<div class="scheduling">
<button v-if="this.role == 'DOCTOR' || this.role == 'NURSE'" @click="create = !create">New vacation request</button>
<Form @submit="$refs.requests.reload()" v-if="this.create" />
<p>Vacation Requests</p>

<List ref="requests" v-if="this.role != 'CLINIC_ADMINISTRATOR'" :filter="x => x.user.id == this.user" />

</div>
</template>

<style scoped> 



</style>
