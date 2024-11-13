// src/router/index.js
import { createRouter, createWebHistory } from "vue-router";
import Login from "../views/login_v.vue";
import Dashboard from "../views/MainFrame.vue";

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/dashboard",
    name: "Dashboard",
    component: Dashboard,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

// Guard de navegación para verificar autenticación y rol
router.beforeEach((to, from, next) => {
  const isAuthenticated = !!localStorage.getItem("user");
  const user = isAuthenticated
    ? JSON.parse(localStorage.getItem("user"))
    : null;

  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (!isAuthenticated) {
      next({ name: "Login" });
    } else if (to.name === "Dashboard" && user && !user.admin) {
      next({ name: "NotAuthorized" });
    } else {
      next();
    }
  } else {
    next();
  }
});

export default router;
