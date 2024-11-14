<template>
  <div>
    <login_v v-if="!isAuthenticated" @authenticated="handleLogin" />
    <MainFrame v-else @logout="handleLogout" />
  </div>
</template>

<script>
import login_v from "./views/login_v.vue";
import MainFrame from "./views/MainFrame.vue";

export default {
  name: "App",
  components: {
    login_v,
    MainFrame,
  },
  data() {
    return {
      isAuthenticated: false, 
    };
  },
  computed: {
    currentComponent() {
      
      return this.isAuthenticated ? "MainFrame" : "login_v";
    },
  },
  created() {
    // Verifica si el usuario está autenticado 
    const user = JSON.parse(localStorage.getItem("user"));
    this.isAuthenticated = user && user.admin !== undefined; 
  },
  methods: {
    handleLogin() {
      
      this.isAuthenticated = true;
    },
    handleLogout() {
      
      this.isAuthenticated = false;
    },
  },
};
</script>
