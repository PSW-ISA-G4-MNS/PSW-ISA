<script>
import AddAdminService from "./service";

export default {
    name: "AddAdminClinic",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
          items:[]

        };
    },
    methods: {
    	submit: function() 
	{
		AddAdminService.create(this.data).then(response => this.success = true);
	},

	changeJobTitle (event) {
      this.selectedJobTitle = event.target.options[event.target.options.selectedIndex].text
    }
	},
	mounted: function () 
    {
        AddAdminService.list().then(response => this.items = response.data);
    },
}
</script>

<template>
    <div class="drop-down"> 
        <div v-if="success">Creation successful</div>
	<div v-if="!success"> 

	<b-dropdown id="dropdown-1" text="Dropdown Button" class="m-md-2">
    <b-dropdown-item v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id">

		{{item.username}}
  </b-dropdown>
		

		<p><button v-on:click="submit">Submit</button></p>
	</div>
    </div>

</template>

<style scoped> 



</style>
