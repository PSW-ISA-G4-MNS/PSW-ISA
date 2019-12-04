<script>
import AddAdminClinicService from "./service";
import AddAdminClinic from "./AddAdminClinic.vue";


export default {
    name: "AddAdminClinictMulti",
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
        AddAdminClinicService.list().then(response => this.items = response.data);
    },
    components: {
    	"AddAdminClinic": AddAdminClinic
    }
}
</script>

<template>
    <div class="AddAdminClinicMulti"> 
        <b-dropdown id="dropdown-1" text="Dropdown Button" class="m-md-2">
  
            <AddAdminClinic
      	        v-for="item in items.filter(filter)"
      	        :id="item.id"
      	        :key="item.id"
                :request="item.id"
            />
        </b-dropdown>

        
    </div>

</template>

<style scoped> 



</style>
