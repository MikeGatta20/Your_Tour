<template>
  <div class="home">
    <h1>Home</h1>
    <p>You are authenticated if you see this.</p>
    <SearchCriteria/>
  </div>
</template>

<script>
import SearchCriteria from '../components/SearchCriteria.vue';
export default {
  components: {
    SearchCriteria
  }
};
</script>
