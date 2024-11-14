<template>
  <div class="dashboard">
    <BoxComponent title="Inicio" :isAdmin="isAdmin" route="/inicio" />
    <BoxComponent title="Graduados" :isAdmin="isAdmin" adminOnly route="/graduados" />
    <BoxComponent title="Usuarios" :isAdmin="isAdmin" route="/usuarios" />
    <BoxComponent title="Carreras" :isAdmin="isAdmin" route="/carreras" />
    <BoxComponent title="Trabajos" :isAdmin="isAdmin" adminOnly route="/trabajos" />
    <BoxComponent title="Descarga datos" :isAdmin="isAdmin" route="/descarga-datos" />
  </div>
</template>

<script>
import BoxComponent from "@/components/BoxComponent.vue";

export default {
  components: {
    BoxComponent,
  },
  data() {
    return {
      isAdmin: JSON.parse(localStorage.getItem("user"))?.admin || false, // Determina si es admin o no
    };
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
</style>
