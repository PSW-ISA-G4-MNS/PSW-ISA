<script>
import UserService from "./service";

export default {
    name: "WidgetUserSingleEdit",
    props: ["user"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        UserService.get(this.user).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-user-single-edit"> 
    <div v-if="!success"> 
		<p>
		<input type="text" class="form-control" placeholder="name" v-model="data.name" />
		</p>
		
        <p>
		<input type="text" class="form-control" placeholder="lastname" v-model="data.lastname" />
		</p>

        <p>
		<input type="date" class="form-control" placeholder="birthday" v-model="data.birthday" />
		</p>

		<p>
		<input type="text" class="form-control" placeholder="address" v-model="data.address" />
		</p>

        <p>
		<input type="number" class="form-control" placeholder="mobile_phone" v-model="data.mobile_phone" />
		</p>
		
		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

</style>