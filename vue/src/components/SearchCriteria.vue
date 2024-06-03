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
                {{ landmark.name }} - {{ landmark.distance }} miles away
            </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
    return {
        filteredLandmarks: [],

        landmarks: [
            {   id: 1,
                name: "Montreal Museum of Fine Arts",
                description: "The Montreal Museum of Fine Arts (MMFA) is the oldest art museum in Canada, with a collection of over 44,000 works.",
                distance: 2.5, 
                isOpen: true,
                startTime: "10:00 AM",
                endTime: "6:00 PM",
                category: "Art Museum",
                images: ["museum_image1.jpg", "museum_image2.jpg"]
            },
            {
                id: 2,
                name: "Montreal Biodome",
                description: "The Montreal Biodome is a facility located at Olympic Park in Montreal, Canada, that allows visitors to walk through replicas of four ecosystems found in the Americas.",
                distance: 4.0,
                isOpen: true,
                startTime: "9:00 AM",
                endTime: "5:00 PM",
                category: "Ecological Park",
                images: ["biodome_image1.jpg", "biodome_image2.jpg"]
            },
            {
                id: 3,
                name: "Notre-Dame Basilica",
                description: "Notre-Dame Basilica is a basilica in the historic district of Old Montreal. The interior of the church is among the most dramatic in the world and regarded as a masterpiece of Gothic Revival architecture.",
                distance: 0.8,
                isOpen: false,
                startTime: "9:00 AM",
                endTime: "4:00 PM",
                category: "Basilica",
                images: ["notre_dame_image1.jpg", "notre_dame_image2.jpg"]
            }
        ]
    }
},
methods: {
    searchLandmarks(){
        this.filteredLandmarks = this.landmarks.filter(landmark => {
            return landmark.distance <= this.distance &&
               landmark.startTime >= this.startTime &&
               landmark.endTime <= this.endTime; 
        })
    }
}


  }
  </script>
  