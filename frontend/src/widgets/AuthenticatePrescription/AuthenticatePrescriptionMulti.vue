<script>
import AuthenticatePrescriptionService from "./service";
import AuthenticatePrescriptionSingle from "./AuthenticatePrescriptionSingle.vue";


export default {
    name: "AuthenticatePrescriptionMulti",
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
       
    },
    components: {
    	"AuthenticatePrescriptionSingle": AuthenticatePrescriptionSingle
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
    
    
      <AuthenticatePrescriptionSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Authenticationrequest="item"
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
