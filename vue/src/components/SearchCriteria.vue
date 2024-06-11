<template>
  <div>
    <form @submit.prevent="searchLandmarks">
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
              <img class="landmark-images" :src="landmark.landmark.landmarkImage" alt="Image Not Found">
              <button @click="toggleSchedule(index)">
                {{ showScheduleIndex === index ? 'Hide Schedule' : 'Show Schedule' }}
              </button>
              <svg @click="clickForLike(false, index, landmark.landmark.landmarkId)" :fill="landmark.dislikeColor || 'currentColor'" class="bi bi-hand-thumbs-down dislike" viewBox="0 0 16 16">
                <path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2 2 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a10 10 0 0 0-.443.05 9.4 9.4 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a9 9 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.2 2.2 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.9.9 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
              </svg>
              <svg @click="clickForLike(true, index, landmark.landmark.landmarkId)" :fill="landmark.likeColor || 'currentColor'" class="bi bi-hand-thumbs-up like" viewBox="0 0 16 16">
                <path d="M8.864 15.674c-.956.24-1.843-.484-1.908-1.42-.072-1.05-.23-2.015-.428-2.59-.125-.36-.479-1.012-1.04-1.638-.557-.624-1.282-1.179-2.131-1.41C2.685 8.432 2 7.85 2 7V3c0-.845.682-1.464 1.448-1.546 1.07-.113 1.564-.415 2.068-.723l.048-.029c.272-.166.578-.349.97-.484C6.931.08 7.395 0 8 0h3.5c.937 0 1.599.478 1.934 1.064.164.287.254.607.254.913 0 .152-.023.312-.077.464.201.262.38.577.488.9.11.33.172.762.004 1.15.069.13.12.268.159.403.077.27.113.567.113.856s-.036.586-.113.856c-.035.12-.08.244-.138.363.394.571.418 1.2.234 1.733-.206.592-.682 1.1-1.2 1.272-.847.283-1.803.276-2.516.211a10 10 0 0 1-.443-.05 9.36 9.36 0 0 1-.062 4.51c-.138.508-.55.848-1.012.964zM11.5 1H8c-.51 0-.863.068-1.14.163-.281.097-.506.229-.776.393l-.04.025c-.555.338-1.198.73-2.49.868-.333.035-.554.29-.554.55V7c0 .255.226.543.62.65 1.095.3 1.977.997 2.614 1.709.635.71 1.064 1.475 1.238 1.977.243.7.407 1.768.482 2.85.025.362.36.595.667.518l.262-.065c.16-.04.258-.144.288-.255a8.34 8.34 0 0 0-.145-4.726.5.5 0 0 1 .595-.643h.003l.014.004.058.013a9 9 0 0 0 1.036.157c.663.06 1.457.054 2.11-.163.175-.059.45-.301.57-.651.107-.308.087-.67-.266-1.021L12.793 7l.353-.354c.043-.042.105-.14.154-.315.048-.167.075-.37.075-.581s-.027-.414-.075-.581c-.05-.174-.111-.273-.154-.315l-.353-.354.353-.354c.047-.047.109-.176.005-.488a2.2 2.2 0 0 0-.505-.804l-.353-.354.353-.354c.006-.005.041-.05.041-.17a.9.9 0 0 0-.121-.415C12.4 1.272 12.063 1 11.5 1"/>
              </svg>
              <div>

                <p v-for="rating in filteredRatings(landmark.landmark.landmarkId)" :key="rating.landmarkId">thumbs up: {{ rating.thumbs_up }}</p>
                <p v-for="rating in filteredRatings(landmark.landmark.landmarkId)" :key="rating.landmarkId">thumbs down: {{ rating.thumbs_down }}</p>
              </div>


            </div>
            <input type="checkbox" :id="'landmarkCheckbox_' + index" v-model="isChecked[index]" @change="checkboxChanged(landmark)">
            <label :for="'landmarkCheckbox_' + index">Add to Itinerary</label>
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
    <div>
      <p>Your starting point: 1228 Sherbrooke St W, Montreal, Quebec</p>
    </div>
    <label >Please select a date</label>
    <input type="date">
    <ul>
      <li v-for="(landmark, landmarkIndex) in landmarksItinerary" :key="landmarkIndex">
        <p> {{ landmark.landmark.landmarkName }}</p>
      </li>
    </ul>
    <Routes :landmarksItinerary="landmarksItinerary"></Routes>
  </div>
</template>

<script>
import SearchLandmarkService from '../services/SearchLandmarksService.js';
import Routes from '../components/Routes.vue';
import RatingService from '../services/RatingService.js';
export default {
  components: {
    Routes
  },
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
      showScheduleIndex: null,
      images: null,
      landmarksItinerary: [],
      isChecked: [],
      ratings: []
    };
  },
  methods: {
  filteredRatings(landmarkId) {
    return this.ratings.filter(rating => rating.landmark_id === landmarkId);
  },


    clickForLike(isThumbsUp, index, landmarkId) {
      if (isThumbsUp) {
        if (this.filteredLandmarks[index].likeColor === "red") {
          let newRating = {
          thumbs_down: 0,
          thumbs_up: 0,
          user_id: 1,
          landmark_id: landmarkId
      };
          console.log(newRating)

          RatingService.updateRatings(newRating);
          this.filteredLandmarks[index].likeColor = "";
        } else {
          let newRating = {
          thumbs_down: 1,
          thumbs_up: 0,
          user_id: 1,
          landmark_id: landmarkId
          };
          console.log(newRating)
          RatingService.updateRatings(newRating); 
          this.filteredLandmarks[index].likeColor = "red";
          this.filteredLandmarks[index].dislikeColor = "";

        }
                 
  }    else {
        if (this.filteredLandmarks[index].dislikeColor === "green") {
          let newRating = {
          thumbs_down: 0,
          thumbs_up: 0,
          user_id: 1,
          landmark_id: landmarkId
          };
          console.log(newRating)
          RatingService.updateRatings(newRating);  
          this.filteredLandmarks[index].dislikeColor = "";
    } else {
          let newRating = {
          thumbs_down: 0,
          thumbs_up: 1,
          user_id: 1,
          landmark_id: landmarkId
          };
          console.log(newRating)
          RatingService.updateRatings(newRating); 
          this.filteredLandmarks[index].dislikeColor = "green";
          this.filteredLandmarks[index].likeColor = "";
        }
      }
    

    },


    searchLandmarks() {
      if(this.distance > 0 && this.category != null) {
        this.filteredLandmarks = this.landmarks.filter(landmark => {
          return landmark.landmark.distance <= this.distance &&
            landmark.landmark.category.toLowerCase() === this.category.toLowerCase();
        });
      } else if (this.distance >0) {
        this.filteredLandmarks = this.landmarks.filter(landmark => {
          return landmark.landmark.distance <= this.distance;
        });
      } else if(this.category != null) {
        this.filteredLandmarks = this.landmarks.filter(landmark => {
          return landmark.landmark.category.toLowerCase() === this.category.toLowerCase();
        });
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
      
    },
    checkboxChanged(landmark) {
      const index = this.filteredLandmarks.findIndex(l => l === landmark);
      if (index !== -1) {
        if (this.isChecked[index]) {
          this.landmarksItinerary.push(landmark);
        } else {
          const itineraryIndex = this.landmarksItinerary.indexOf(landmark);
          if (itineraryIndex !== -1) {
            this.landmarksItinerary.splice(itineraryIndex, 1);
          }
        }
      }
    }
  },
  created() {
    SearchLandmarkService.getAllLandmarks().then(response => {
      this.filteredLandmarks = response.data;
      this.isChecked = new Array(this.filteredLandmarks.length).fill(false);
    }).catch(error => {
      console.error('Error fetching landmarks:', error);
    });
  },
mounted(){
  RatingService.getAllRatings().then(response => {
    this.ratings = response.data;

  
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
.landmark-images {
 height: 150px;
 width: 150px;
 }

 .like {
  height: 60px;
  width: 60px; 
 
  }

  .dislike {
    height: 60px;
    width: 60px; 
  }
</style>