<script>
import RoomService from "./service";
import Room from "./Room.vue";


export default {
    name: "multi-Room",
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
        RoomService.list().then(response => this.items = response.data);
    },
    components: {
    	"Room": Room
    }
}
</script>

<template>
    <div class="multi-Room"> 
      <Room
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :Room="item.id"
          />
    </div>

</template>

<style scoped> 



</style>
