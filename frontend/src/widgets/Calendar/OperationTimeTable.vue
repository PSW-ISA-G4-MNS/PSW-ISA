<script>
import CalendarService from './service';


export default {
    name: "OperationTimeTable",
    props:[ "operation","datum"],
    data: function () {
        return {
            data: {},
           

        };
    },

    
        mounted: function() {

		
		
    },
    
    methods: {
    	submit: function() 
	{
		
	}
    }
}
</script>

<template>
   

<tr>
      <td id="vreme">{{operation.startTime.toString().replace(datum+"T", " ")}}</td>
      <td id="obaveza">{{operation.patient.id}} {{operation.patient.user.firstname}} {{operation.patient.user.lastname}}</td>
      

        
    </tr>


</template>

<style scoped> 

input{
width: 50%;
  padding: 12px 20px;
  
  box-sizing: border-box;
}

td{
  width: 200px;
  height: 50px;
 background-color: #f9f9f9;
  
}
tr{
  width: 200px;
  height: 50px;
  min-width: 120px;
  padding: 10px 20px;
}

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
