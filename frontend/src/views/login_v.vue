<template>
  <div class="login-container">
    <h2 class="title">Inicio de Sesión</h2>
    <form @submit.prevent="login">
      <div class="form-group">
        <label for="email">Correo Institucional</label>
        <input type="email" v-model="email" id="email" required />
      </div>
      <div class="form-group">
        <label for="password">Contraseña</label>
        <input type="password" v-model="password" id="password" required />
      </div>
      <button type="submit" class="login-button">Iniciar Sesión</button>
    </form>
    <p v-if="message" :class="{ admin: isAdmin, user: !isAdmin }">
      {{ message }}
    </p>
  </div>
</template>

<script>
import { RequestHandler } from "../services/RequestHandler";

export default {
  data() {
    return {
      email: "",
      password: "",
      message: "",
      isAdmin: false,
    };
  },
  methods: {
    async login() {
      const requestHandler = new RequestHandler();

      const usuarios = await requestHandler.getRequest("/usuario/getUsuarios");
      const usuario = usuarios.find(
        (user) =>
          user.correoinstitucional === this.email &&
          user.contrasenha === this.password
      );

      if (usuario) {
        this.isAdmin = usuario.admin;
        this.message = this.isAdmin
          ? "Inicio de sesión exitoso: Administrador"
          : "Inicio de sesión exitoso: Usuario estándar";

        // Guardar usuario en localStorage para autentificación
        localStorage.setItem("user", JSON.stringify(usuario));

        // Redirigir según el rol
        if (this.isAdmin) {
          this.$router.push({ name: "Dashboard" });
        } else {
          this.$router.push({ name: "Dashboard" });
        }
      } else {
        this.message = "Correo o contraseña incorrectos";
        this.isAdmin = false;
      }
    },
  },
};
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: auto;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
}

.title {
  text-align: center;
  color: #34495e;
  margin-bottom: 20px;
  font-size: 24px;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  font-weight: bold;
  color: #34495e;
  margin-bottom: 5px;
}

.form-group input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  transition: border-color 0.3s;
}

.form-group input:focus {
  border-color: #1abc9c;
}

.login-button {
  width: 100%;
  padding: 12px;
  background-color: #1abc9c;
  color: white;
  font-size: 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.login-button:hover {
  background-color: #16a085;
}

.admin {
  text-align: center;
  margin-top: 15px;
  color: #2ecc71;
  font-weight: bold;
}

.user {
  text-align: center;
  margin-top: 15px;
  color: #3498db;
  font-weight: bold;
}
</style>
