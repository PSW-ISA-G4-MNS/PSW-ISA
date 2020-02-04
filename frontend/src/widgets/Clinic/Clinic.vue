<script>
import ClinicService from "./service";
import Map from 'ol/Map';
import View from 'ol/View';
import TileLayer from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import * as proj from 'ol/proj';
import Feature from "ol/Feature";
import Point from "ol/geom/Point";
import Vector from "ol/source/Vector";
import * as olLayer from "ol/layer";

export default {
    name: "Clinic",
    props: ["Clinic"],
    data: function () {
        return {
            data: {},
	    map: null,
        other: {}
        }
    },
    mounted: function () 
    {

        this.other.careTypeId = localStorage.getItem('selectedCareType');
        this.other.date = localStorage.getItem('selectedDate');

        ClinicService.get(this.Clinic).then(response => {
		this.data = response.data
		this.map = new Map({
        		target: 'map',
        		layers: [
          			new TileLayer({
            				source: new OSM()
          			})
        		],
        		view: new View({
          			center: proj.fromLonLat([this.data.locationLat, this.data.locationLon]),
          			zoom: 4
        		})
      		});
		var marker = new Feature({
  			geometry: new Point(proj.fromLonLat([this.data.locationLat, this.data.locationLon])),
		});
		var vectorSource = new Vector({
			  features: [marker]
		});
		var markerVectorLayer = new olLayer.Vector({
			  source: vectorSource,
		});
		this.map.addLayer(markerVectorLayer);
	});
    },
    methods: 
    {
    	deleteItem: function() 
        {
            ClinicService.delete(this.Clinic).then(response => this.data = {});
        },
        showClinic: function()
        {
            localStorage.setItem('selectedClinic', this.Clinic);
            window.location.href = "/frontend/#/CareList";
        },
        showDoctors: function()
        {
            if(this.other.date !== undefined && this.other.careTypeId !== undefined){
                localStorage.setItem('selectedClinic', this.Clinic);
                window.location.href = "/frontend/#/ClinicDoctorsList";
            } else 
            {
                alert('Please select preffered date and care type to view available doctors.');
            }
        }
	// add additional methods here
    }
}
</script>

<template>
    <div class="widget-Clinic"> 
    <span class="badge badge-pill badge-info">Clinic: </span>

    <div class="card" style="width: 18rem;">
      <p>{{ data.name }}</p>
      <div class="card-body">
        <h5 class="card-title"></h5>
        <p class="card-text item-description"></p>
      </div>

    
     <ul class="list-group list-group-flush">
        <li class="list-group-item">Description: {{data.description}}</li>
        <li class="list-group-item">Address: {{data.address}}</li>
        <li class="list-group-item">Location: {{data.locationLat}} {{data.locationLon}}</li>
     </ul>

    <button class="btn btn-primary" @click="showClinic">Predefined cares</button>
    <button class="btn btn-primary" @click="showDoctors">Available doctors</button>

    <div class="card-body">
    </div>
    </div>
    <div id="map" class="map"></div>
    </div>

</template>

<style scoped> 

.map {
	width: 200px;
	height: 200px;
}


</style>
