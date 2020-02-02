<script>
import AvailableCareService from "./service";

export default {
	name: "WidgetAvailableCareSingle",
	props: ["availableCare"],
    data: function () {
        return {
          	availableCare: {},
		        success: false

        };
    },
    methods: {
      sendCareRequest: function()
      {
          AvailableCareService.sendCareRequest(this.availableCare);
      }
    }
}
</script>

<template>
    

  <tr v-if="!success">
      <td id="name">{{ availableCare.doctor.user.firstname }} {{ availableCare.doctor.user.lastname}}</td>
      <td id="caretype">{{ availableCare.doctor.careType.name}}</td>
      <td id="time">{{ availableCare.startTime}}</td>
      <td id="availableCares">
              <button v-on:click="sendCareRequest" style="background-color:green;color:white;height:40px;width:200px">
                Send care request
              </button>
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