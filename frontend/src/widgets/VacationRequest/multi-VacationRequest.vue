<script>
import VacationRequestService from "./service";
import VacationRequest from "./VacationRequest.vue";
import fullCalendar from 'vue-fullcalendar'


export default {
    name: "multi-VacationRequest",
    props: {
        filter: {
            type: Function,
            default: (x => true),
        }
    },
    data: function () {
        return {
            items: [],
            events: [],
            role: localStorage.getItem("role")

        }
    },
    mounted: function () 
    {
        VacationRequestService.list().then(response => {
            this.items = response.data;
            this.events = response.data.map(x => {return {
                    title: "Vacation for " + x.user.firstname + " " + x.user.lastname,
                    start: x.startTime,
                    end: x.endTime
            }});
        });

    },
    methods: {
	reload: function () 
	{
        	VacationRequestService.list().then(response => {
                this.items = response.data
                this.events = response.data.map(x => {return {
                    title: "Vacation for " + x.user.firstname + " " + x.user.lastname,
                    start: x.startTime,
                    end: x.endTime
                }});
            });

	}
    },
    components: {
    	"VacationRequest": VacationRequest,
        fullCalendar
    }
}
</script>

<template>
<div>
    <fullCalendar v-if="this.role == 'CLINIC_ADMINISTRATOR'" :events="events" />
    <div class="multi-VacationRequest"> 
      <VacationRequest
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :VacationRequest="item.id"
          />
    </div>
</div>
</template>

<style scoped> 



</style>
