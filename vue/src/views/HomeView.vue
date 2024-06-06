<template>
  <div class="home">
    <div v-if="Object.keys(landmarks).length === 0">Loading landmarks...</div>
    <div v-else>
      <h1>Landmarks</h1>
      <div class="landmarks-menu">
        <ul>
          <li v-for="(landmark, index) in landmarks" :key="index">
            <div class="landmark-item">
              <div class="landmark-info">
                
                <h3>{{ landmark.landmark.landmarkName }}</h3>
                <p>{{ landmark.landmark.address }}</p>
                <p>{{ landmark.landmark.category }}</p>
                <p>{{ landmark.landmark.description }}</p>
                <p>Distance: {{ landmark.landmark.distance }}</p>
              </div>
              <img src={{ landmark.landmark.images }} alt="Image Not Found." > 
              <p>Monday hours: {{ landmark.schedule.openTime}}</p>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <h2>Plan Your Tour !!</h2>
    <SearchCriteria :landmarks="landmarks"/>
  </div>
</template>

<script>
import SearchCriteria from '../components/SearchCriteria.vue';
import SearchLandmarkService from '../services/SearchLandmarksService.js'; 

export default {
  components: {
    SearchCriteria
  },
  data() {
    return {
      landmarks: []
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
</style>