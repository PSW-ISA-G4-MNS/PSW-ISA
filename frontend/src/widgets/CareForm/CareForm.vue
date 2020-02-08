<script>
import CareFormService from "./service";
import DoctorService from "../Doctor/service";
import RoomService from "../Room/service";

import flatPickr from 'vue-flatpickr-component';
import 'flatpickr/dist/flatpickr.css';

export default {
    name: "CareForm",
    data: function () {
        return {
            data: {
	    },
	    doctors: [],
	    rooms: [],
	    success: false

        };
    },
	components: {
		flatPickr,
	},
    mounted: function() {
    	DoctorService.list().then(response => {
		this.doctors = response.data; 
	});
    	RoomService.list().then(response => {
		this.rooms = response.data; 
	});
    },
    methods: {
    	submit: function() 
	{
		this.data.startTime = this.data.startTime.replace(" ", "T");
		this.data.endTime = this.data.endTime.replace(" ", "T");
		CareFormService.submit(this.data).then(response => {
			if (response.data.code == 0) this.data.success = true;
			else this.data.success = false;

		});
	},
	selectDoctor: function(index) {
		console.log("Called with id = " + index);
		this.data.doctorId = this.doctors[index].id;
	},
	selectRoom: function(index) {
		console.log("Called with id = " + index);
		this.data.roomId = this.rooms[index].id;
	}
    }
}
</script>

<template>
    <div class="form-CareForm"> 
        <div class="success-box" v-if="success">Care created</div>
	<div v-if="!success"> 
		
		<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonDoctor" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select doctor
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonDoctor">
		    <a :key="doctor.id" :id="doctor.id" @click="selectDoctor(index)" v-for="(doctor, index) in this.doctors" class="dropdown-item" href="#">{{ doctor.user.firstname }} {{ doctor.user.lastname}}</a>
		  </div>
		</div>
		&nbsp;
		&nbsp;
		&nbsp;
		<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonRoom" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select room
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonRoom">
		    <a :key="room.id" :id="room.id" @click="selectRoom(index)" v-for="(room, index) in this.rooms" class="dropdown-item" href="#">Room: {{ room.title}}</a>
		  </div>
		</div>
		&nbsp;
		&nbsp;
		&nbsp;
		<p>
		<input type="number" class="form-control" placeholder="Price" v-model="data.price" />
		</p>
		
		<p>
		<flatPickr :config="{enableTime: true}" v-model="data.startTime" />
		</p>
		
		<p>
		<flatPickr  :config="{enableTime: true}" v-model="data.endTime" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

</style>
