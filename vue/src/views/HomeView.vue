<template>
  <div class="home">
    <div v-if="Object.keys(landmarks).length === 0">Loading landmarks...</div>
    <div v-else>
      <h1>Landmarks</h1>
      <h2>Plan Your Tour !!</h2>
      <SearchCriteria :landmarks="landmarks"/>
      
    </div>
    
    
  </div>
</template>

<script>
import SearchCriteria from '../components/SearchCriteria.vue';
import SearchLandmarkService from '../services/SearchLandmarksService.js'; 

export default {
  components: {
    SearchCriteria,
  
  },
  data() {
    return {
      landmarks: [],
      showScheduleIndex: null
    }
  },
  methods: {
    toggleSchedule(index) {
      if (this.showScheduleIndex === index) {
        this.showScheduleIndex = null;
      } else {
        this.showScheduleIndex = index;
      }
    }
  },
  created() {
    SearchLandmarkService.getAllLandmarks().then(response => {
      this.landmarks = response.data;
    }).catch(error => {
      console.error('Error fetching landmarks:', error);
    });
  }
};
</script>

<style>
.landmarks-menu {
  max-height: 300px; /* Adjust the height as needed */
  overflow-y: auto;
}

.landmark-item {
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 10px;
  display: flex;
  align-items: center;
}

.landmark-info {
  flex: 1;
}

.landmark-info h3 {
  margin: 0;
}

.landmark-info p {
  margin: 5px 0;
}

.schedule {
  margin-top: 10px;
}
</style>