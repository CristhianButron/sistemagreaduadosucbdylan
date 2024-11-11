<template>
  <header class="header">
    <div class="search-bar">
      <button @click="searchPersona">
        <i class="fas fa-search"></i>
      </button>
      <input
        type="text"
        placeholder="Buscar graduado por ID"
        v-model="searchId"
      />
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
      searchId: "",
    };
  },
  methods: {
    async searchPersona() {
      if (!this.searchId) return;

      const api = new RequestHandler();
      try {
        const persona = await api.getRequest(
          `/persona/getPersona/${this.searchId}`
        );
        this.$emit("personaEncontrada", persona);
      } catch (error) {
        console.error("Error al buscar la persona:", error);
      }
    },
  },
};
</script>

<style scoped>
/* Importación de Font Awesome para los iconos (opcional) */
@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css");
</style>
