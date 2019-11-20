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
	}
	},
	mounted: function () 
    {
        ReqistrationRequestService.list().then(response => this.items = response.data);
    },
}
</script>

<template>
    <div class="widget-user-new"> 
        <div v-if="success">Creation successful</div>
	<div v-if="!success"> 
		<div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :request="item.id"
          />
  </li>
  </ul>
</div>
		

		<p><button v-on:click="submit">Submit</button></p>
	</div>
    </div>

</template>

<style scoped> 



</style>
