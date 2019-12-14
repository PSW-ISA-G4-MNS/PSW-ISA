<script>
import CareService from "./service";
import WidgetCareSingle from "./WidgetCareSingle.vue";


export default {
    name: "WidgetCareMulti",
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
        CareService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetCareSingle": WidgetCareSingle
    }
}
</script>


<template>
  <table>
    <thead>
      <tr>
        <th
          @click="sortBy(doctor)"
          :class="{ active: sortKey == doctor }">
          Doctor
          <span class="arrow" :class="sortOrders[key] > 0 ? 'asc' : 'dsc'">
          </span>
        </th>
        <th
          @click="sortBy(time)"
          :class="{ active: sortKey == time }">
          Time
          <span class="arrow" :class="sortOrders[key] > 0 ? 'asc' : 'dsc'">
          </span>
        </th>
        <th
          @click="sortBy(type)"
          :class="{ active: sortKey == type }">
          Type
          <span class="arrow" :class="sortOrders[key] > 0 ? 'asc' : 'dsc'">
          </span>
        </th>
        <th
          @click="sortBy(price)"
          :class="{ active: sortKey == price }">
          Price
          <span class="arrow" :class="sortOrders[key] > 0 ? 'asc' : 'dsc'">
          </span>
        </th>
      </tr>
    </thead>
    
     <div class="WidgetCareSingle"> 
      <WidgetCareSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :care="item.id"
          />
    </div>
    
  </table>


</template>


<style scoped>

body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #42b983;
  border-radius: 3px;
  background-color: #fff;
}

th {
  background-color: #42b983;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #f9f9f9;
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