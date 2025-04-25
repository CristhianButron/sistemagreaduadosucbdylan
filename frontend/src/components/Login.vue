<template>
  <div class="login-container">
    <div class="login-box">
      <h2>Login</h2>
      <form @submit.prevent="handleLogin" class="login-form">
        <div class="form-group">
          <label>Email institucional</label>
          <input
            v-model="user.correoinstitucional"
            type="email"
            class="form-control"
            required
          />
        </div>
        <div class="form-group">
          <label>Contraseña</label>
          <input
            v-model="user.contrasenha"
            type="password"
            class="form-control"
            required
          />
        </div>
        <div class="alert alert-danger" v-if="error">
          {{ error }}
        </div>
        <button type="submit" :disabled="loading">
          {{ loading ? 'Loading...' : 'Login' }}
        </button>
        <!-- Add this inside your form, after the submit button -->
        <p class="register-link">
          ¿No tienes una cuenta? <router-link to="/register">Registrarse</router-link>
        </p>
        
        
      </form>
    </div>
  </div>
</template>

<script>
import AuthService from '../services/authService';

export default {
  name: 'Login',
  data() {
    return {
      user: {
        correoinstitucional: '',
        contrasenha: ''
      },
      loading: false,
      error: ''
    };
  },
  methods: {
    async handleLogin() {
      this.loading = true;
      this.error = '';
      try {
        const response = await AuthService.login(this.user);
        if (response.token) {
          this.$router.push('/dashboard');
        }
      } catch (error) {
        this.error = 'Invalid credentials';
      } finally {
        this.loading = false;
      }
    }
  }
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f5f5;
}
        
.login-box {
  padding: 2rem;
  background: white;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0,0,0,0.1);
  width: 100%;
  max-width: 500px;
}

.login-form {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

input {
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  padding: 0.75rem;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:disabled {
  background-color: #cccccc;
}

.alert {
  padding: 0.75rem;
  background-color: #f8d7da;
  color: #721c24;
  border-radius: 4px;
}

.register-link {
  text-align: center;
  margin-top: 1rem;
}
        
.register-link a {
  color: #4CAF50;
  text-decoration: none;
}
        
.register-link a:hover {
   text-decoration: underline;
}
</style>