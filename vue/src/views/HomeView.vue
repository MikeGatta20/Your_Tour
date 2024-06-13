<template>
  <div class="home">
    <div v-if="Object.keys(landmarks).length === 0">Loading landmarks...</div>
    <div v-else>
      <div class ="header-text">
      <h1>Welcome to Montreal</h1>
      <h2>Plan Your Tour Today!</h2>
    </div>
    </div>
    <img src="/logo.png" id="logo" alt="Logo">
   
  </div>
  <SearchCriteria :landmarks="landmarks"/>
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

.home{
  text-align: center;
}

.header-text {
  text-align: center;
  margin-bottom: 40px;
 
  font-size: 100px; /* Adjust font size for better readability */
  margin-top: 20px; /* Add some space between the logo and headings */
  color: #fff; /* White text color */
  background-color: #e96f6f;
  padding: 20px; /* Add some padding to make it look like a sticker */
  border-radius: 10px; /* Rounded corners to enhance the sticker effect */
  box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2), /* Larger shadow for pop-out effect */
              0 6px 6px rgba(0, 0, 0, 0.1); /* Secondary shadow for depth */
  transform: scale(1.1); /* Slightly scale up to emphasize the pop-out effect */
  transition: transform 0.2s; /* Smooth transition for scaling effect */
  width: 60%;
  margin: auto;
  
}

.header-text:hover {
  transform: scale(1.2); /* Scale up more on hover to enhance the effect */
}

#logo {
  height: auto; /* Allow the logo to adjust its height while maintaining aspect ratio */
  width: 80%; /* Adjust width for responsiveness */
  max-width: 600px; /* Set a maximum width for larger screens */
  margin-top: 50px; /* Add some space between the headings and logo */ /* Increase size and blur, make shadow darker */

  border: 10px solid #e96f6f;
  border-radius: 100px;
  padding: 20px;
  margin-bottom: 45px;
}
h1{
  font-size:90px;
}

h2 {
  font-size: 45px;
}
</style>