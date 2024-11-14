<template>
  <div>
    <div class="logout-button">
      <button @click="logout">Cerrar Sesión</button>
    </div>
    <div class="dashboard">
      <BoxComponent title="Inicio" :isAdmin="isAdmin" route="/inicio" />
      <BoxComponent title="Graduados" :isAdmin="isAdmin" adminOnly route="/graduados" />
      <BoxComponent title="Usuarios" :isAdmin="isAdmin" route="/usuarios" />
      <BoxComponent title="Carreras" :isAdmin="isAdmin" route="/carreras" /> 
      <BoxComponent title="Trabajos" :isAdmin="isAdmin" adminOnly route="/trabajos" />
      <BoxComponent title="Descarga datos" :isAdmin="isAdmin" route="/descarga-datos" />
    </div>
  </div>
</template>

<script>
import BoxComponent from "@/components/BoxComponent.vue";

export default {
  components: {
    BoxComponent,
  },
  name: "MainFrame",
  data() {
    return {
      isAdmin: JSON.parse(localStorage.getItem("user"))?.admin || false, 
    };
  },
  methods: {
    logout() {
      // Limpia memoria
      localStorage.removeItem("user");

      
      this.$emit("logout");

    
      this.$router.push({ name: "Login" });
    },
  },
};
</script>

<style scoped>
.dashboard {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 15px;
  max-width: 800px;
  margin: auto;
  padding: 20px;
}

.logout-button {
  display: flex;
  justify-content: flex-end;
  padding: 10px;
}

.logout-button button {
  padding: 8px 16px;
  background-color: #e74c3c;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
  transition: background-color 0.3s ease;
}

.logout-button button:hover {
  background-color: #c0392b;
}
</style>
