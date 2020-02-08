<script>
import CareService from "./service";
import ReviewPage from "../Review/ReviewPage.vue";

import RoomSelection from "../Room/RoomSelection.vue";
import DoctorSelection from "../Doctor/DoctorSelection.vue";
import TimeSelection from "./TimeSelection.vue";
import ClinicService from "../Clinic/service";


export default {
	name: "WidgetCareSingle",
	props: ["care"],
    data: function () {
        return {
          	data: {},

		        success: false,
            role: localStorage.getItem('role'),

		        finalized: false,
            clinic: null,


        };
    },
    methods: {
    	reservate: function() 
      {
        CareService.reservate(this.data.id).then(response => {


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
        CareService.decline(this.data).then(response => {
          if (response.status == 200) this.success = true;
          else this.success = false;

        });
      },
      selectDoctor: function(doctor) {
        this.data.doctor = doctor;
        CareService.update(this.care, this.data).then(response => {
          alert("Doctor assigned");
        });
      },
      selectRoom: function(room) {
        this.data.room = room;
        CareService.update(this.care, this.data).then(response => {
          alert("Room assigned");
        });
      },
      selectTime: function (time) {
        time = time.replace(" ", "T");
        this.data.startTime = time;
         CareService.update(this.care, this.data).then(response => {
          alert("time assigned");
        });
      }
	

	},
	
	mounted: function () 
    {
        CareService.get(this.care).then(

          response => {
            console.log(response.data);;
            this.data = response.data;
            
            console.log(this.data);
          }
        );

        if (this.role == "DOCTOR" || this.role == "CLINIC_ADMINISTRATOR") {
          ClinicService.list().then(response => {
            this.clinic = response.data[0];
          });
        }
    },
    components: {
	ReviewPage,
  RoomSelection,
  TimeSelection,
  DoctorSelection
    }

}
</script>

<template>
    

  <tr v-if="!success">
      <td id="time">{{ data.startTime == null ? "No time" : data.startTime.toString().replace("T", " ")}}</td>
      <td id="doctor">{{ data.doctor == null ? "" : data.doctor.user.firstname + " " + data.doctor.user.lastname}}</td>
      <td id="caretype">{{ data.careType == null ? "" : data.careType.name}}</td>
      <td id="price">{{ data.price}}</td>
      <td id="reservate">
              <button v-if="this.role == 'PATIENT'" v-on:click="reservate" style="background-color:green;color:white;height:40px;width:200px">
              Reservate
              </button>
	      <button v-if="this.role == 'DOCTOR' && !this.finalized" @click="finalizeCare">Finalize</button>
	      <ReviewPage v-if="this.finalized" :careId="care.id" :patientId="care.patient.id" />
        <RoomSelection v-if="this.clinic != null" @select="selectRoom" :filter="x => x.clinic.id == this.clinic.id"/>
        <DoctorSelection v-if="this.clinic != null" @select="selectDoctor" :filter="x => x.clinic.id == this.clinic.id"/>
        <TimeSelection v-if="this.clinic != null" @select="selectTime" />

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
