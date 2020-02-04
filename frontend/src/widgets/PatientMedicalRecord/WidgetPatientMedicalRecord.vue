<script>
import PatientMedicalRecordService from "./service";

export default {
	name: "WidgetPatientMedicalRecord",
    data: function () {
        return {
          	patientInfo: {},
		    success: false,
            role: localStorage.getItem('role')

        };
    },
	
	mounted: function () 
    {
        PatientMedicalRecordService.get().then(response => this.patientInfo = response.data);
    }
}
</script>

<template>
<div>
    <h2>Welcome, {{patientInfo.patient.user.firstname}} {{patientInfo.patient.user.lastname}}</h2>
    <p> &nbsp; </p>
    <h3> User data </h3>
    <p>&nbsp;&nbsp;&nbsp;&nbsp; <b>Insurance ID:</b> {{patientInfo.patient.insuranceID}} </p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp; <b>Date of birth:</b> {{patientInfo.patient.user.birthday}} </p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp; <b>E-mail:</b> {{patientInfo.patient.user.email}} </p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp; <b>Phone number:</b> {{patientInfo.patient.user.mobilePhone}} </p>
    <p> &nbsp; </p>
    <h3> Medical record data </h3>
    <p>&nbsp;&nbsp;&nbsp;&nbsp; <b>Height:</b> {{patientInfo.medicalRecord.height}} </p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp; <b>Weight:</b> {{patientInfo.medicalRecord.width}} </p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp; <b>Blood type:</b> {{patientInfo.medicalRecord.bloodType}} </p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp; <b>Diopter:</b> {{patientInfo.medicalRecord.diopter}} </p>

</div>


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