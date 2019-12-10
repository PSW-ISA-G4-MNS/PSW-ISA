<script>
import ClinicService from "./service";
import Clinic from "./Clinic.vue";


export default {
    name: "multi-Clinic",
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
        ClinicService.list().then(response => this.items = response.data);
    },
    components: {
    	"Clinic": Clinic
    }
}
</script>

<template>
    <div class="multi-Clinic"> 
      <Clinic
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Clinic="item.id"
          />
    </div>

</template>

<style scoped> 



</style>
