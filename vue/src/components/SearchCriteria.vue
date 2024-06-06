<template>

  <div>
    <form @submit.prevent="searchLandmarks">
      <div>
        <p>Your starting point: 1228 Sherbrooke St W, Montreal, Quebec</p>
      </div>
      <div>
        <label for="distance">How many miles would you like to travel? </label>
        <input type="number" name="distance" max="20" min="0" step="0.1" v-model.number="distance" required>
      </div>
      <div> 
        <label for="category">Please choose a category</label>
        <select v-model="category" required>
          <option v-for="(category, index) in categoryOptions" :key="index">{{ category }}</option>
        </select>
      </div>
      <div>
        <label for="dayOfWeek">Please select a day</label>
        <select v-model="dayOfWeek" required>
          <option v-for="(dayOfWeek, index) in dayOfWeekOptions" :key="index" >{{ dayOfWeek }}</option>
        </select>
      </div>
      
      <button type="submit">Search Landmarks</button>
    </form>
    <div>
      <label>Landmarks Found</label>
      <ul>
        <li v-for="landmark in filteredLandmarks" :key="landmark.landmark.landmarkId">
          {{ landmark.landmark.landmarkName }} - {{ landmark.landmark.distance }} miles away
          {{ landmark.schedule.dayOfWeek }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
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
      categoryOptions: ["Museum", "Historic Site", "Park", "Church", "Garden"] 
    };
  },
 
  methods: {
  

    searchLandmarks() {
     this.filteredLandmarks = this.landmarks.filter(landmark => {
      return landmark.landmark.distance <= this.distance &&
      landmark.landmark.category.toLowerCase() === this.category.toLowerCase(); 
     })
   
    },
    getSchedule( landmarkId ,dayOfWeek){
     
    }
  },



}
</script>