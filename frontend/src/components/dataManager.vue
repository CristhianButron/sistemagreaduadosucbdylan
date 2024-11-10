<template>
  <div>
    <h2>Data Manager</h2>
    <button @click="fetchData">Fetch Data</button>
    <ul>
      <li v-for="item in data" :key="item.id">{{ item.name }}</li>
    </ul>
  </div>
</template>

<script>
import { RequestHandler } from "../services/RequestHandler";

export default {
  name: "DataManager",
  data() {
    return {
      data: [], // Inicializamos el array para almacenar los datos obtenidos
    };
  },
  methods: {
    async fetchData() {
      const api = new RequestHandler();
      try {
        const responseData = await api.getRequest("/usuario/getUsuarios");
        this.data = responseData; // Asignamos los datos a la propiedad data
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    },
  },
};
</script>

<style scoped>
/* Estilos opcionales */
</style>
