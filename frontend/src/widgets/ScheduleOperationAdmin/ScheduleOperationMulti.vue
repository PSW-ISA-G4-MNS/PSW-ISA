<script>
import ScheduleOperationService from "./service";
import ScheduleOperationSingle from "./ScheduleOperationSingle.vue";


export default {
    name: "ScheduleOperationMulti",
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
        ScheduleOperationService.list().then(response => this.items = response.data);
    },
    components: {
    	"ScheduleOperationSingle": ScheduleOperationSingle
    }
}
</script>


<template>


<div>
<h1>
    Predefined cares for {{items[0].doctor.clinic.name}}
</h1>
  <table >
    <tr>
        <th>OR id</th>
        <th>Patient Firstname </th>
        <th>Patient LastName </th>
        <th>OR time </th>
        <th></th>
    </tr>
    
      <WidgetCareSingle 
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :operationRequest="item"
          />
      
    
  </table>
</div>


</template>


<style scoped>

body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #49bcf6;
  border-radius: 3px;
  background-color: #fff;
  width: 1320px;
}

th {
  background-color: #49bcf6;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #49bcf6;
}

th, td {
  min-width: 120px;
  padding: 10px 20px;
}

th.active {
  color: #fff;
}

th.active .arrow {
  opacity: 1;
}

.arrow {
  display: inline-block;
  vertical-align: middle;
  width: 0;
  height: 0;
  margin-left: 5px;
  opacity: 0.66;
}

.arrow.asc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-bottom: 4px solid #fff;
}

.arrow.dsc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-top: 4px solid #fff;
}


</style>