<template>
  <div class="table-container">
    <table v-if="persona">
      <thead>
        <tr>
          <th>CI</th>
          <th>Nombre</th>
          <th>Fecha Nacimiento</th>
          <th>Género Nacimiento</th>
          <th>Nacionalidad</th>
          <th>Apellido Paterno</th>
          <th>Apellido Materno</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{{ persona.ci }}</td>
          <td>{{ persona.nombre }}</td>
          <td>{{ persona.fechaNacimiento }}</td>
          <td>{{ persona.generoNacimiento }}</td>
          <td>{{ persona.nacionalidad }}</td>
          <td>{{ persona.apaterno }}</td>
          <td>{{ persona.amaterno }}</td>
        </tr>
      </tbody>
    </table>
    <p v-else>No se ha encontrado ninguna persona</p>
  </div>
</template>

<script>
export default {
  props: {
    persona: {
      type: Object,
      default: null,
    },
  },
};
</script>
