<template>
  <div class="flex h-screen">
    <Sidebar />
    <div class="flex-1">
      <Header @personaEncontrada="actualizarTabla" />
      <Table :persona="persona" />
    </div>
  </div>
</template>

<script>
import Sidebar from "../../components/graduados/Sidebar_c.vue";
import Header from "../../components/graduados/header_c.vue";
import Table from "../../components/graduados/Table_c.vue";
import "../../assets/Styles_graduados.css";

export default {
  components: {
    Sidebar,
    Header,
    Table,
  },
  data() {
    return {
      persona: null,
    };
  },
  methods: {
    actualizarTabla(persona) {
      this.persona = persona; // Actualiza los datos de la persona en el estado
    },
  },
};
</script>

<style scoped>
/* Optional additional styling */
</style>
