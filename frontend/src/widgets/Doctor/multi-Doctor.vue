<script>
import DoctorService from "./service";
import Doctor from "./Doctor.vue";


export default {
    name: "multi-Doctor",
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
        DoctorService.list().then(response => this.items = response.data);
    },
    components: {
    	"Doctor": Doctor
    }
}
</script>

<template>
    <div class="multi-Doctor"> 
      <Doctor
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Doctor="item.id"
          />
    </div>

</template>

<style scoped> 



</style>