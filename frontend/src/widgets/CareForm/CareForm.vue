<script>
import CareFormService from "./service";
import DoctorService from "../Doctor/service";
import RoomService from "../Room/service";

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
		
		<div class="dropdown">
		  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButtonRoom" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Select room
		  </button>
		  <div class="dropdown-menu" aria-labelledby="dropdownMenuButtonRoom">
		    <a :key="room.id" :id="room.id" @click="selectRoom(index)" v-for="(room, index) in this.rooms" class="dropdown-item" href="#">Room: {{ room.title}}</a>
		  </div>
		</div>
		
		<p>
		<input type="number" class="form-control" placeholder="Price" v-model="data.price" />
		</p>
		
		<p>
		<input type="datetimet" class="form-control" placeholder="Start" v-model="data.startTime" />
		</p>
		
		<p>
		<input type="datetime" class="form-control" placeholder="End" v-model="data.endTime" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
	</div>
    </div>

</template>

<style scoped> 

.form-CareForm {

}

.success-box 
{
	backgrund-color: #dfd;
	color: #0f0;
	padding: 5px;
}

</style>
