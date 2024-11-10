<template>
  <img alt="Vue logo" src="./assets/logo.png" />
  <DataManager />
</template>

<script>
import DataManager from "../src/components/dataManager.vue";

export default {
  name: "App",
  components: {
    DataManager,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
