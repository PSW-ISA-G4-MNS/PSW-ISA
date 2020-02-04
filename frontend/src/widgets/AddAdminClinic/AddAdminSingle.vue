<script>
import AddAdminClinicService from "./service";


export default {
    name: "AddAdminSingle",
    props: ["admin", "idKlinike"],
    data: function () {
        return {
            data: {},
            success:false,
            
        }
    },

    methods:{

    	add: function() {
            
            AddAdminClinicService.add(this.data).then(response => {


      if (response.status == 200){ 
        this.success = true;
        
      }
			else this.success = false;

		});
           
    
      }
    
    },
    mounted: function () 
    {
        
        
       
       
    },
    watch: { 
    
      idKlinike:function() {

      
    this.data.Clinic_Id=this.idKlinike;
       this.data.Admin_Id=this.admin.id;
      }
    },
}
</script>

<template>

     <tr >
      
      <td id="firstname">{{admin.user.firstname}}</td>
      <td id="lastname">{{admin.user.lastname}}</td>
      
      
      <td id="reservate">
              <button  v-if="!success" v-on:click="add" style="background-color:green;color:white;height:40px;width:200px">
              Add
              </button>
        </td>

      
  </tr>
  

</template>



<style scoped> 


.widget-admin-single {
	padding: 10px; 
	background-color: #ffcccc; 
	margin: 10px;
}


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
