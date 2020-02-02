<script>
import CareTypeService from "./service";
import CareType from "./CareType.vue";


export default {
    name: "multi-CareType",
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
        CareTypeService.list().then(response => this.items = response.data);
    },
    components: {
    	"CareType": CareType
    }
}
</script>

<template>
    <div class="multi-CareType"> 
      <CareType
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :CareType="item.id"
          />
    </div>

</template>

<style scoped> 



</style>