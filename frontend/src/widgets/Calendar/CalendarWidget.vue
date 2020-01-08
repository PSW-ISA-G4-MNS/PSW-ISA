<script>

import ReviewTimeTable from "./ReviewTimeTable.vue";
import CalendarService from"./service";
import OperationTimeTable from "./OperationTimeTable.vue";

export default {
    name: "Calendar",
    data: function () {
        return {
            data: {},
            pickDate:null,
            cares:{},
            operations:{}
        };
    },

    watch: { 
    
      pickDate:function() {

      CalendarService.getCares(this.pickDate).then(response => {
		this.cares= response.data; 
  });

   CalendarService.getOperations(this.pickDate).then(response => {
		this.operations= response.data; 
  });
  
      }
    },
        mounted: function() {
        
    
    
		
		
    },
   

    components: {
      "ReviewTimeTable": ReviewTimeTable,
      "OperationTimeTable": OperationTimeTable
    },
    
    methods: {

        

    	submit: function() 
	{
		
	}
    }
}
</script>

<template>
    
    <div>
		<input type="date" class="form-control" placeholder="Date" v-model="pickDate"/>
        &nbsp;
        &nbsp;
        <h3>Timetable for : {{this.pickDate}}</h3>

        <table>
    <tr>
        <th>Time </th>
        <th>Obligation </th>
        <th>Start </th>
    </tr>


    <tr>
     <td></td>
     <td>REVIEWS</td>
     <td></td> 
    </tr>
      <ReviewTimeTable
      	v-for="item in cares"
      	:id="item"
      	:key="item.id"
        :care="item"
        :datum="pickDate"
       
          />

    <tr>
     <td></td>
     <td>OPERATIONS</td>
     <td></td> 
    </tr>

      <OperationTimeTable
      	v-for="item in operations"
      	:id="item"
      	:key="item.id"
        :operation="item"
        :datum="pickDate"
       
          />
      

        </table>
    </div>
</template>

<style scoped> 

input{
width: 50%;
  padding: 12px 20px;
  
  box-sizing: border-box;
}

body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #49bcf6;
  border-radius: 3px;
  background-color: #fff;
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
