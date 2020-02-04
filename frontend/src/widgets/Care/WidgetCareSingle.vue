<script>
import CareService from "./service";
import ReviewPage from "../Review/ReviewPage.vue";
export default {
	name: "WidgetCareSingle",
	props: ["care"],
    data: function () {
        return {
          	care: {},

            success: false,
		        role: localStorage.getItem("role"),

		        finalized: false,


        };
    },
    methods: {
    	reservate: function() 
	{
		CareService.reservate(this.care.id).then(response => {


			if (response.status == 200)this.success = true;
			else this.success = false;

    return {
        renderComponent: true,
      };


		});
  

	},
	finalizeCare: function () {
		this.finalized = true;
	},

	decline: function() 
	{
		CareService.decline(this.care).then(response => {
			if (response.status == 200) this.success = true;
			else this.success = false;

		});
	}
	

	},
	
	mounted: function () 
    {
        CareService.get(this.care).then(

	response => {
		console.log(response.data);;
		this.care = response.data;
    
		console.log(this.data);
	}
	);
    },
    components: {
	ReviewPage
    }

}
</script>

<template>
    

  <tr v-if="!success">
      <td id="time">{{care.startTime.toString().replace("T", " ")}}</td>
      <td id="doctor">{{ care.doctor.user.firstname }} {{ care.doctor.user.lastname}}</td>
      <td id="caretype">{{ care.careType.name}}</td>
      <td id="price">{{ care.price}}</td>
      <td v-if="role == 'PATIENT' " id="reservate">
              <button v-on:click="reservate" style="background-color:green;color:white;height:40px;width:200px">
              Reservate
              </button>
	      <button v-if="this.role == 'DOCTOR' && !this.finalized" @click="finalizeCare">Finalize</button>
	      <ReviewPage v-if="this.finalized" :careId="care.id" :patientId="care.patient.id" />
        </td>
  </tr>
  
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
