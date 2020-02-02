<script>
import DoctorService from "./service";
import Doctor from "./Doctor.vue";

export default {
    name: "multi-DoctorPatient",
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
        DoctorService.patients().then(response => this.items = response.data);
    },
    components: {
    	"Doctor": Doctor
    }
}
</script>

<template>
    <div class="multi-DoctorPatient"> 
      <p
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id">
		{{ item.user.firstname}} {{ item.user.lastname}}
        </p>
    </div>

</template>

<style scoped> 



</style>
