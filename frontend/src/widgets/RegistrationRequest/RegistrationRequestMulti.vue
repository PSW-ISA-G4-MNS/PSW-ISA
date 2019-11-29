<script>
import ReqistrationRequestService from "./service";
import ReqistrationRequest from "./RegistrationRequest.vue";


export default {
    name: "RegistrationRequestMulti",
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
        ReqistrationRequestService.list().then(response => this.items = response.data);
    },
    components: {
    	"ReqistrationRequest": ReqistrationRequest
    }
}
</script>

<template>
    <div class="ReqistrationRequest"> 
      <ReqistrationRequest
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :request="item.id"
          />


    </div>

</template>

<style scoped> 



</style>
