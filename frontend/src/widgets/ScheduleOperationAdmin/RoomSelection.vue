<script>
import RoomService from "../Room/service";
import RoomOption from "./RoomOption.vue";

export default {
	name: "RoomSelection",
	props: ["operationRequest","doctors"],
    data: function () {
        return {
            items: [],
          	care: {},
            search: "",
            success: false,
            

        };
    },
    methods: {
  

	},
	
	mounted: function () 
    {
      RoomService.list().then(response => {
          this.items = response.data;
      })
    },
    components: {
        RoomOption
    }
}
</script>

<template>
<div>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" :data-target="'#Modal-' + operationRequest.id">
  Schedule
</button>

<!-- Modal -->
<div class="modal fade" :id="'Modal-' + operationRequest.id" tabindex="-1" role="dialog" :aria-labelledby="'ModalLabel' + operationRequest.id" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" :id="'ModalLabel' + operationRequest.id">Choose room</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div>
          <input type="text" placeholder="Room name" v-model="search.name" />
          <RoomOption v-for="item in items.filter(x => x.clinic.id == this.operationRequest.clinic.id && x.title.includes(this.search.name))" 
            :operationRequest="operationRequest" :doctors="doctors" :key="item.id" :room="item.id" />
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</div>
</template>

<style scoped>

</style>>