<template>
  <div class="register-container">
    <div class="register-box">
      <h2>Registro de Usuario</h2>
      <form @submit.prevent="handleRegister" class="register-form">
        <!-- Existing email and password fields -->
        <div class="form-group">
          <label>Correo Institucional</label>
          <input v-model="user.correoinstitucional" type="email" required />
        </div>
        <div class="form-group">
          <label>Contraseña</label>
          <input v-model="user.contrasenha" type="password" required />
        </div>

        <!-- Updated persona fields -->
        <div class="form-group">
          <label>CI</label>
          <input v-model="user.personaDto.ci" type="text" required />
        </div>
        <div class="form-group">
          <label>Nombres</label>
          <input v-model="user.personaDto.nombres" type="text" required />
        </div>
        <div class="form-group">
          <label>Apellido Paterno</label>
          <input v-model="apellidoPaterno" type="text" required />
        </div>
        <div class="form-group">
          <label>Apellido Materno</label>
          <input v-model="apellidoMaterno" type="text" required />
        </div>

        <!-- Cargo field -->
        <div class="form-group">
          <label>Cargo</label>
          <input v-model="user.cargo" type="text" required />
        </div>

        <!-- Optional carrera selection -->
        <div class="form-group">
          <label>Carrera (Opcional)</label>
          <select v-model="user.carrera_id_carrera">
            <option :value="null">Sin carrera</option>
          </select>
        </div>

        <div class="alert alert-danger" v-if="error">
          {{ error }}
        </div>
        <button type="submit" :disabled="loading">
          {{ loading ? 'Registrando...' : 'Registrar' }}
        </button>
        <p class="login-link">
          ¿Ya tienes una cuenta? <router-link to="/login">Iniciar sesión</router-link>
        </p>
      </form>
    </div>
  </div>
</template>

<script>
import AuthService from '../services/authService';

export default {
  name: 'Register',
  data() {
    return {
      user: {
        correoinstitucional: '',
        contrasenha: '',
        cargo: '',
        admin: false,
        carrera_id_carrera: null,
        personaDto: {
          ci: '',
          nombres: '',
          apellidos: ''
        }
      },
      carreras: [],
      loading: false,
      error: ''
    };
  },
  async created() {
    try {
      // Fetch carreras when component is created
      this.carreras = await CarrerasService.getAllCarreras();
    } catch (error) {
      console.error('Error fetching carreras:', error);
    }
  },
  methods: {
    async handleRegister() {
      this.loading = true;
      this.error = '';
      try {
        // Combine apellidos before sending
        this.user.personaDto.apellidos = `${this.apellidoPaterno} ${this.apellidoMaterno}`.trim();
        await AuthService.register(this.user);
        this.$router.push('/login');
      } catch (error) {
        this.error = error.response?.data || 'Error en el registro';
      } finally {
        this.loading = false;
      }
    }
  }
};
</script>

<style scoped>
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f5f5f5;
  padding: 1rem;
}

.register-box {
  padding: 2rem;
  background: white;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0,0,0,0.1);
  width: 100%;
  max-width: 500px;
}

.register-form {
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

.login-link {
  text-align: center;
  margin-top: 1rem;
}

.login-link a {
  color: #4CAF50;
  text-decoration: none;
}

.login-link a:hover {
  text-decoration: underline;
}

/* Add style for select element */
select {
  padding: 0.5rem;
  border: 1px solid #ddd;
  border-radius: 4px;
  width: 100%;
  background-color: white;
}
</style>