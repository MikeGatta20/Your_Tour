import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getAllLandmarks() {
    return axios.get('/search/allLandmarks')
  },

  getLandmarkByName(name) {
    return axios.get('/search/name/${name}')
  },

  getLandmarkByCategory(category) {
    return axios.get('/search/category/${category}')
  }

}
