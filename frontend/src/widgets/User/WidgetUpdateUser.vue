<script>
import UserService from "./service";

export default {
    name: "WidgetUpdateUser",
    props: ["user"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function()
    {
        UserService.get(this.user).then(response => this.data = response.data);
    }
}
</script>

<template>

<div class="form-update-user-form"> 
        <div class="success-box" ></div>
	
		<p>
		<input type="text" class="form-control" text= {{data.firstname}} placeholder="firstname" v-model="data.name" />
		</p>
		
		<p>
		<input type="text" class="form-control" text={{data.lastname}} placeholder="lastname" v-model="data.lastname" />
		</p>
		
		<p>
		<input type="text" class="form-control" text={{data.mobile_phone}} placeholder="mobilePhone" v-model="data.mobile_phone" />
		</p>
		
		<p>
		<input type="text" class="form-control" text={{data.address}} placeholder="address" v-model="data.address" />
		</p>
		
		<p>
		<input type="date" class="form-control" date={{data.birthday}} placeholder="birthday" v-model="data.birthday" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="update">Submit</button>
	</div>


</template>

<style scoped> 



</style>
