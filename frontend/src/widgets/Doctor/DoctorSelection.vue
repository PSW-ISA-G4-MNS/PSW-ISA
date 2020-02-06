<script>
import DoctorService from "./service";
import DoctorOption from "./DoctorOption.vue";

export default {
    name: "DoctorSelection",
    props: {
      filter: {
              type: Function,
              default: (x => true)
      }
    },
    data: function () {
        return {
            items: [],
          	care: {},
            search: {
              name: "",
            },
            success: false,
            

        };
    },
	
	mounted: function () 
    {
      this.randomId = Math.floor(Math.random() * 1000000);
      DoctorService.list().then(response => {
          this.items = response.data;
          this.success = true;
          console.log("Assigned ModalID: " + this.randomId);
      })
    },
    components: {
        DoctorOption
    },
    methods: {
      reservate: function(Doctor) {
        this.$emit("select", Doctor);
      }
    }
}
</script>

<template>
<div>
<!-- Button trigger modal -->
<button v-if="this.success" type="button" class="btn btn-primary" data-toggle="modal" :data-target="'#Modal-' + this.randomId">
  Select Doctor
</button>

<!-- Modal -->
<div v-if="this.success" class="modal fade" :id="'Modal-' + this.randomId" tabindex="-1" role="dialog" :aria-labelledby="'ModalLabel' + this.randomId" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" :id="'ModalLabel' + this.randomId">Choose Doctor</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div>
          <input type="text" placeholder="Doctor name" v-model="search.name" />
          <DoctorOption @select="reservate" 
            v-for="item in items.filter(x =>  ((x.user.firstname + ' ' + x.user.lastname).includes(this.search.name) && this.filter(x)))"
            :key="item.id" :Doctor="item.id" />
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