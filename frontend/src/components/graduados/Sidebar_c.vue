<template>
  <div class="sidebar">
    <h2 class="sidebar-title">Menú de Navegación</h2>
    <ul class="sidebar-menu">
      <li
        v-for="item in menuItems"
        :key="item.text"
        @click="navigate(item.route)"
        :class="{ active: isActive(item.route) }"
      >
        <i :class="item.icon"></i>
        <span>{{ item.text }}</span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      menuItems: [
        { text: "Inicio", route: "/inicio", icon: "fas fa-home" },
        { text: "Carreras", route: "/carreras", icon: "fas fa-flag-checkered" },
        { text: "Usuarios", route: "/usuarios", icon: "fas fa-users" },
        { text: "Ajustes", route: "/ajustes", icon: "fas fa-cogs" },
      ],
    };
  },
  methods: {
    navigate(route) {
      this.$router.push(route);
    },
    isActive(route) {
      return this.$route.path === route;
    },
  },
};
</script>

<style scoped>
.sidebar {
  width: 250px;
  height: 100vh;
  background-color: #2c3e50;
  color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 20px;
  box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
  transition: width 0.3s ease;
}

.sidebar-title {
  font-size: 20px;
  margin-bottom: 30px;
  color: #ecf0f1;
}

.sidebar-menu {
  list-style: none;
  padding: 0;
  width: 100%;
}

.sidebar-menu li {
  width: 100%;
  padding: 15px 20px;
  cursor: pointer;
  display: flex;
  align-items: center;
  color: #bdc3c7;
  transition: background-color 0.3s, color 0.3s;
}

.sidebar-menu li:hover,
.sidebar-menu li.active {
  background-color: #34495e;
  color: #ecf0f1;
}

.sidebar-menu li i {
  margin-right: 15px;
  font-size: 18px;
}

.sidebar-menu li span {
  font-size: 16px;
}

.sidebar-menu li.active i,
.sidebar-menu li:hover i {
  color: #1abc9c;
}

.sidebar-menu li.active span,
.sidebar-menu li:hover span {
  color: #1abc9c;
}

/* Responsive adjustments */
@media (max-width: 768px) {
  .sidebar {
    width: 60px;
  }

  .sidebar-title {
    display: none;
  }

  .sidebar-menu li span {
    display: none;
  }

  .sidebar-menu li i {
    margin-right: 0;
    font-size: 22px;
  }
}
</style>
