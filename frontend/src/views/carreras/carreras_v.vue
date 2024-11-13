<template>
  <div class="register-race">
    <h2 class="title">Registrar Nueva Carrera</h2>
    <form @submit.prevent="registerRace" class="race-form">
      <div class="form-group">
        <label for="nombre">Nombre de la Carrera</label>
        <input type="text" v-model="race.nombre" id="nombre" required />
      </div>
      <div class="form-group">
        <label for="sigla">Sigla de la Carrera</label>
        <input type="text" v-model="race.sigla" id="sigla" required />
      </div>
      <button type="submit" class="submit-button">Guardar Carrera</button>
    </form>
    <p v-if="message" :class="{ success: success, error: !success }">
      {{ message }}
    </p>
  </div>
</template>

<script>
import { RequestHandler } from "../../services/RequestHandler";

export default {
  data() {
    return {
      race: {
        idCarrera: 0,
        nombre: "",
        sigla: "",
      },
      message: "",
      success: false,
    };
  },
  methods: {
    async registerRace() {
      const requestHandler = new RequestHandler();
      try {
        await requestHandler.postRequest("/carreras/guardarCarrera", this.race);
        this.message = "Carrera registrada exitosamente.";
        this.success = true;
      } catch (error) {
        this.message = "Error al registrar la carrera. Inténtalo de nuevo.";
        this.success = false;
      }
    },
  },
};
</script>

<style scoped>
.register-race {
  max-width: 500px;
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

.race-form {
  display: flex;
  flex-direction: column;
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

.submit-button {
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

.submit-button:hover {
  background-color: #16a085;
}

.success {
  text-align: center;
  margin-top: 15px;
  color: #2ecc71;
  font-weight: bold;
}

.error {
  text-align: center;
  margin-top: 15px;
  color: #e74c3c;
  font-weight: bold;
}
</style>
