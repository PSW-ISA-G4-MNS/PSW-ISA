<script>
import PatientService from "./service";
import WidgetPatientSingleNurse from "./WidgetPatientSingleNurse.vue";


export default {
    name: "WidgetPatientMultiNurse",
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
        PatientService.getAll().then(response => this.items = response.data);
    },
    components: {
    	"WidgetPatientSingleNurse": WidgetPatientSingleNurse
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
    
    
      <WidgetPatientSingleNurse
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :patient="item.id"
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
