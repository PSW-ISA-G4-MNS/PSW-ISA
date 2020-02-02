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
      AuthenticatePrescriptionService.list().then(response => {
	 this.items = response.data; 
	});
    },
    components: {
    	"AuthenticatePrescriptionSingle": AuthenticatePrescriptionSingle
    }
}
</script>

<template>
<table class="form">
    <tr>
        <th>Prescription ID </th>
        <th>Medicines </th>
        <th>Apr or Dec</th>
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

.form {
position:relative;
    top:20%;
    left:20%;
	padding: 40px; 
	margin: 40px;
	text-align: center;
	width: 60%;
}


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
