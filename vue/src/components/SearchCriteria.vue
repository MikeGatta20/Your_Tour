<template>
  <div>
    <form @submit.prevent="searchLandmarks">
      <div>
        <p>Your starting point: 1228 Sherbrooke St W, Montreal, Quebec</p>
      </div>
      <div>
        <label for="distance">How many miles would you like to travel? </label>
        <input type="number" name="distance" max="20" min="0" step="0.1" v-model.number="distance">
      </div>
      <div> 
        <label for="category">Please choose a category</label>
        <select v-model="category">
          <option v-for="(category, index) in categoryOptions" :key="index">{{ category }}</option>
        </select>
      </div>
      <button type="submit">Search Landmarks</button>
    </form>
    <div class="landmarks-box">
      <label>Landmarks Found</label>
      <ul>
        <li v-for="(landmark, index) in filteredLandmarks" :key="landmark.landmark.landmarkId">
          <div class="landmark-item">
            <div class="landmark-info">
              <h3>{{ landmark.landmark.landmarkName }}</h3>
              <p>{{ landmark.landmark.address }}</p>
              <p>{{ landmark.landmark.category }}</p>
              <p>{{ landmark.landmark.description }}</p>
              <p>Distance: {{ landmark.landmark.distance }} miles</p>
              <img :src="landmark.landmark.images" alt="Image Not Found">
              <button @click="toggleSchedule(index)">
                {{ showScheduleIndex === index ? 'Hide Schedule' : 'Show Schedule' }}
              </button>
            </div>
            <div v-if="showScheduleIndex === index" class="schedule">
              <h4>Schedule:</h4>
              <ul>
                <li v-for="(schedule, scheduleIndex) in landmark.schedule" :key="scheduleIndex">
                  <p>{{ schedule.dayOfWeek }}: {{ schedule.openTime }} - {{ schedule.closeTime }}</p>
                </li>
              </ul>
            </div>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import SearchLandmarkService from '../services/SearchLandmarksService.js';

export default {
  props: {
    landmarks: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      filteredLandmarks: [],
      distance: 0,
      dayOfWeekOptions: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
      dayOfWeek: null,
      startTime: null,
      endTime: null,
      category: null,
      categoryOptions: ["Museum", "Historic Site", "Park", "Church", "Garden"],
      showScheduleIndex: null
    };
  },
  methods: {
    searchLandmarks() {
      if(this.distance > 0 && this.category != null) {
      this.filteredLandmarks = this.landmarks.filter(landmark => {
        return landmark.landmark.distance <= this.distance &&
               landmark.landmark.category.toLowerCase() === this.category.toLowerCase();
      });
    } else if (this.distance >0) {
      this.filteredLandmarks = this.landmarks.filter(landmark => {
        return landmark.landmark.distance <= this.distance;
      })
  }   else if(this.category != null) {
    this.filteredLandmarks = this.landmarks.filter(landmark => {
        return landmark.landmark.category.toLowerCase() === this.category.toLowerCase();

  })
}
    },
    toggleSchedule(index) {
      if (this.showScheduleIndex === index) {
        this.showScheduleIndex = null;
      } else {
        this.showScheduleIndex = index;
      }
    },
    getSchedule(landmarkId, dayOfWeek) {
      // Functionality for getting schedule can be implemented here
    }
  },
  created() {
    SearchLandmarkService.getAllLandmarks().then(response => {
      this.filteredLandmarks = response.data;
    }).catch(error => {
      console.error('Error fetching landmarks:', error);
    });
  }
}
</script>

<style scoped>
.landmarks-box {
  max-height: 300px; /* Adjust the height as needed */
  overflow-y: auto;
  border: 1px solid #ccc;
  padding: 10px;
  margin-top: 10px;
}

.landmark-item {
  border-bottom: 1px solid #ccc;
  padding: 10px 0;
  margin-bottom: 10px;
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
