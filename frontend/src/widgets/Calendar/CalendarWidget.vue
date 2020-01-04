<script>

import TimeTable from "./TimeTable.vue";


export default {
    name: "Calendar",
    data: function () {
        return {
            data: {},
            pickDate:null,
            times:["7:00 am", "7:30 am","8:00 am","8:30 am","9:00 am","9:30 am","10:00 am","10:30 am","11:00 am","11:30 am",
            "12:00 pm","12:30 pm", "1:00 pm","1:30 pm","2:00 pm","2:30 pm","3:00 pm","3:30 pm","4:00 pm","4:30 pm", "5:00 pm",
             "5:30 pm", "6:00 pm", "6:30 pm", "7:00 pm", "7:30 pm", "8:00 pm", "9:00 pm", "9:30 pm","10:00 pm", "10:30 pm",
             "11:00 pm", "11:30 pm","12:00 am", "12:30 am","1:00 am", "1:30 am","2:00 am", "2:30 am","3:00 am", "3:30 am",
             "4:00 am", "4:30 am","5:00 am", "5:30 am","6:00 am", "6:30 am", ]

        };
    },
        mounted: function() {
    
    
    ;
		
		
    },

    components: {
    	"TimeTable": TimeTable
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


      <TimeTable
      	v-for="item in times"
      	:id="item"
      	:key="item"
        :time="item"
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
