<script>


import flatPickr from 'vue-flatpickr-component';
import 'flatpickr/dist/flatpickr.css';


export default {
    name: "TimeSelection",
    props: {
    },
    data: function () {
        return {
            time: null
        };
    },
	
	mounted: function () 
    {
      this.randomId = Math.floor(Math.random() * 1000000);
      
    },
    components: {
        flatPickr,
    },
    methods: {
      reservate: function() {
        this.$emit("select", this.time.replace(" ", "T"));
        $("Modal-" + this.randomId).modal("hide");
      }
    }
}
</script>

<template>
<div>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" :data-target="'#Modal-' + this.randomId">
  Select Time
</button>

<!-- Modal -->
<div class="modal fade" :id="'Modal-' + this.randomId" tabindex="-1" role="dialog" :aria-labelledby="'ModalLabel' + this.randomId" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" :id="'ModalLabel' + this.randomId">Choose room</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            <p>
            <flatPickr :config="{enableTime: true}" v-model="time" />
            </p>
            <button @click="reservate">Confirm Time</button>
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