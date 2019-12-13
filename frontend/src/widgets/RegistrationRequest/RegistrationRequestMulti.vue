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
<table>
    <tr>
        <th>Insurance ID </th>
        <th>First Name </th>
        <th>Last Name </th>
        <th>Buttons </th>
    </tr>
    
    
      <ReqistrationRequest
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :request="item.id"
          />


    
</table>
</template>

<style scoped> 

table,td,tr,th {
   border: 1px solid black;
  border-collapse: collapse;

}
td,th{
  width: 200px;
  height: 80px;
}

</style>
