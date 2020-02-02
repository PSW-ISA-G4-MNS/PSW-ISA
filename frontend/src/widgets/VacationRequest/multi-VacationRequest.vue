<script>
import VacationRequestService from "./service";
import VacationRequest from "./VacationRequest.vue";


export default {
    name: "multi-VacationRequest",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: []
        }
    },
    mounted: function () 
    {
        VacationRequestService.list().then(response => this.items = response.data);
    },
    methods: {
	reload: function () 
	{
        	VacationRequestService.list().then(response => this.items = response.data);
	}
    },
    components: {
    	"VacationRequest": VacationRequest
    }
}
</script>

<template>
    <div class="multi-VacationRequest"> 
      <VacationRequest
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :VacationRequest="item.id"
          />
    </div>

</template>

<style scoped> 



</style>
