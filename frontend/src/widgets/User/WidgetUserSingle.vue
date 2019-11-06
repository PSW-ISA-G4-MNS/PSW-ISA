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
    mounted: function () 
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
  </div>
</div>

    </div>

</template>

<style scoped> 



</style>
