<script>
import ReviewService from "./service";
import WidgetDiagnosisSingle from "./Review.vue";
import WidgetDrugSingle from "./Review.vue";

export default {
    name: "WidgetReview",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            dijagnoze: [],
            lekovi:[],
            data:{},
            recept:[]
        }
    },
    mounted: function () 
    {
        ReviewService.getDiagnosis().then(response => this.dijagnoze = response.data);
    },
    components: {
        "WidgetDiagnosisSingle": WidgetDiagnosisSingle,
        "WidgetDrugSingle":WidgetDrugSingle
    }
}
</script>

<template>
    <div class="WidgetReview"> 

        <p>
		<input type="text" class="form-control" placeholder="Izvestaj" v-model="data.comment" />
		</p>


        <b-dropdown id="dropdown-1" text="Dropdown Button" class="m-md-2">
  
            <WidgetDiagnosisSingle
      	        v-for="item in dijagnoze.filter(filter)"
      	        :id="item.id"
      	        :key="item.id"
                :request="item.id"
            />
        </b-dropdown>

        <b-dropdown id="dropdown-2" text="Dropdown Button" class="m-md-2">
  
            <WidgetDrugSingle
      	        v-for="item in lekovi.filter(filter)"
      	        :id="item.id"
      	        :key="item.id"
                :request="item.id"
            />
        </b-dropdown>
        <button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="addDrug">Add Medicine</button>

        <button type="button" class="btn btn-primary btn-lg btn-block" >Dodatni Pregled</button>

        <button type="button" class="btn btn-primary btn-lg btn-block" >Zakazi Operaciju</button>

        <button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">ZavrsiPregled</button>
    </div>

</template>

<style scoped> 



</style>
