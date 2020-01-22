<script>
import ClinicService from "./service";
import ClinicReport from "./ClinicReport.vue";


export default {
    name: "multi-ClinicReport",
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
    	"ClinicReport": ClinicReport
    }
}
</script>

<template>
    <div class="multi-ClinicReport"> 
      <ClinicReport
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :ClinicReport="item.id"
          />
    </div>

</template>

<style scoped> 



</style>
