<script>
import RoomSelection from "./RoomSelection.vue";
import ScheduleOperationService from "./service";

export default {
	name: "ScheduleOperationSingle",
	props: ["operationRequest","newDate", "doctors"],
  data: function () {
      return {
          data: {},
          care: {},
          success: false,
          request: {}
      };
  },
	mounted: function () 
    {
      this.data.patient=this.operationRequest.patient;
      this.data.startTime=this.newDateTime;
      this.data.doctors=this.doctors;
    
    },
  components: {
    RoomSelection
  },
  methods: {
    reservate: function(room) 
    {
      this.request.patient=this.operationRequest.patient;
      this.request.startTime=this.data.newStartTime;
      this.request.doctors=this.doctors;
      this.request.room = room;
      ScheduleOperationService.reservate(this.request).then(response => {
        console.log("Proslo");
        ScheduleOperationService.deleteOperationRequest(this.operationRequest.id);
      });
    }
  }
}
</script>

<template>
    

  <tr >
      <td>{{operationRequest.patient.user.id}}</td>
      <td>{{operationRequest.patient.user.firstname}}</td>
      <td>{{operationRequest.patient.user.lastname}}</td>
      <td v-if="operationRequest.startTime!=null">{{operationRequest.startTime.toString().replace("T", " ")}}</td>
      <td  v-else>{{"No time"}}</td>      
      <td>
          <RoomSelection @select="reservate" :doctors="doctors" :operationRequest="operationRequest" />
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

</style>>