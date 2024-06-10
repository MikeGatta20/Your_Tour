import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getAllRatings() {
    return axios.get('/search/getAllRatings')
  },


}