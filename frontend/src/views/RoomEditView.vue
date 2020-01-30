<script>


import RoomEdit from "../widgets/Room/RoomEdit.vue"


export default {
    name: "RRoomEdit",
    props: ["room"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    },
    components: {
    	RoomEdit
    }
}
</script>

<template>
<RoomEdit :Room="this.room" />
</template>

<style scoped> 



</style>
