<script>
import PatientService from "./service";
import Patient from "./WidgetPatientSingle.vue";


export default {
    name: "multi-Patient",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: []
        }
    },
    mounted: function () 
    {
        PatientService.list().then(response => this.items = response.data);
    },
    components: {
    	"Patient": Patient
    }
}
</script>

<template>
    <div class="multi-Patient"> 
      <Patient
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Patient="item.id"
          />
    </div>

</template>

<style scoped> 



</style>
