<script>
import OldReviewChangeService from "./service";

export default {
	name: "OldCare",
	props: ["oldCare"],
    data: function () {
        return {
           
		        
        };
    },
    methods: {
    	change: function() 
	{

    this.$router.push("/changeSingleReview/" + this.oldCare.id);
		
  },

	

	},
	
	mounted: function () 
    {
      
 
  

    }
}
</script>

<template>
    

    
    <tr>
      <td id="careId">{{this.oldCare.id}}</td>
      <td id="date"> {{this.oldCare.startTime.toString().replace("T", " ")}}</td>
      <td id="insurance">{{this.oldCare.patient.insuranceID}}</td>
      <td id="ime">{{ this.oldCare.patient.user.firstname }}</td>
      <td id="prezime">{{ this.oldCare.patient.user.lastname}}</td>
      <td id="dugme">
              <button  v-on:click="change" style="background-color:green;color:white;height:40px;width:200px">
              Change
              </button>
              
           

              
        </td>

      
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
