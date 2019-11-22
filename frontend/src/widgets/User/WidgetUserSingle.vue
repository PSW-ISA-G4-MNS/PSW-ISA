<script>
import UserService from "./service";

export default {
    name: "WidgetUserSingle",
    props: ["user"],
    data: function () {
        return {
            data: {}
        }
    },
<<<<<<< HEAD
    mounted: function() 
=======
    mounted: function()
>>>>>>> a44faf35125381a368b1e1ca73bdb4dbd86068f5
    {
        UserService.get(this.user).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-user-single"> 


<div class="card" style="width: 18rem;">
  <div class="card-header">
    {{ data.username }}
  </div>
  <div class="card-body">
    <h5 class="card-title">{{ data.firstname }} {{ data.lastname }}</h5>
    <p class="card-text">{{ data.email}}</p>
    <p class="card-text">{{ data.address}}</p>
    <p class="card-text">{{ data.mobile_phone}}</p>
    <button v-on:click="update" style="background-color:green;color:white;height:40px;width:200px">
              Izmena informacija
              </button>
  </div>
</div>

    </div>

</template>

<style scoped> 



</style>
