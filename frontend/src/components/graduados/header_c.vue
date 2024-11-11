<template>
  <header class="header">
    <div class="search-bar">
      <input
        type="text"
        placeholder="Buscar graduado por ID"
        v-model="searchId"
      />
      <button @click="searchPersona" class="search-button">
        <i class="fas fa-search"></i> Buscar
      </button>
    </div>
    <div class="user-icon">
      <i class="fas fa-user"></i>
    </div>
  </header>
</template>

<script>
import { RequestHandler } from "../../services/RequestHandler";

export default {
  data() {
    return {
      searchId: "", // ID de la persona a buscar
    };
  },
  methods: {
    async searchPersona() {
      const api = new RequestHandler();
      try {
        if (this.searchId) {
          const persona = await api.getRequest(
            `/persona/getPersona/${this.searchId}`
          );
          this.$emit("personaEncontrada", persona);
        } else {
          console.warn("No se ingresó ningún ID.");
          this.$emit("personaEncontrada", null);
        }
      } catch (error) {
        console.error("Error al buscar la persona:", error);
        this.$emit("personaEncontrada", null); // Emitimos null si hubo un error
      }
    },
  },
};
</script>

<style scoped>
/* Importación de Font Awesome para los iconos (opcional) */
@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css");

/* Botón de búsqueda */
.search-button {
  display: flex;
  align-items: center;
  background-color: #388e3c;
  color: #fff;
  border: none;
  border-radius: 4px;
  padding: 8px 12px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s;
}

.search-button i {
  margin-right: 5px;
}

.search-button:hover {
  background-color: #2e7d32;
}

.user-icon {
  background-color: #66bb6a;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
}
</style>
