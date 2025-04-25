<template>
  <div class="dashboard">
    <h1>Dashboard</h1>
    <p>Welcome, {{ user?.isAdmin ? 'Administrator' : 'User' }}</p>
    <button @click="logout">Logout</button>
  </div>
</template>

<script>
import AuthService from '../services/authService';

export default {
  name: 'Dashboard',
  data() {
    return {
      user: AuthService.getCurrentUser()
    }
  },
  methods: {
    logout() {
      AuthService.logout();
      this.$router.push('/login');
    }
  }
}
</script>

<style scoped>
.dashboard {
  padding: 2rem;
}

button {
  padding: 0.75rem;
  background-color: #dc3545;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
</style>