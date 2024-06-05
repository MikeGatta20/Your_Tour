<template>
    <div>
      <form @submit.prevent="searchLandmarks">
        <div>
          <p>Your starting point: 1228 Sherbrooke St W, Montreal, Quebec</p>
        </div>
        <div>
        <label for="distance">How many miles would you like to travel?</label>
        <input type="number" name="distance" max="20" min="0" step="0.1" v-model.number="distance">
      </div>
      <div>
        <label for="date">Please select a date</label>
        <input type="date" name="date" v-model="selectedDate">
      </div>
      <div>
        <label for="start-time">When is your start time?</label>
        <input type="time" name="start-time" v-model="startTime">
      </div>
      <div>
        <label for="end-time">When is your end time?</label>
        <input type="time" name="end-time" v-model="endTime">
      </div>
        <button type="submit">Search Landmarks</button>
      </form>
      <div>
        <label>Landmarks Found</label>
        <ul>
            <li v-for="landmark in filteredLandmarks" :key="landmark.id">
                {{ landmark.landmarkName }} - {{ landmark.distance }} miles away
            </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      landmarks: {
        
      }
    },
    data() {
    return {
        filteredLandmarks: [],

    }
},
methods: {
    searchLandmarks(){
        this.filteredLandmarks = this.landmarks.filter(landmark => {
            return landmark.distance <= this.distance 
               
              
        })
    }
}, 





  }
  </script>
  