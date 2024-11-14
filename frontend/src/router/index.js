// src/router/index.js
import { createRouter, createWebHistory } from 'vue-router';
import Login from '../views/login_v.vue';
import MainFrame from '@/views/MainFrame.vue';

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login,
  },
  {
    path: '/main',
    name: 'MainFrame',
    component: MainFrame,
    meta: {
      requiresAuth: true,
    },
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  const isAuthenticated = !!localStorage.getItem('user');
  console.log("Guard de navegación: Ruta de destino:", to.name, "Autenticado:", isAuthenticated);

  if (to.matched.some((record) => record.meta.requiresAuth) && !isAuthenticated) {
    next({ name: 'Login' });
  } else {
    next();
  }
});



export default router;
