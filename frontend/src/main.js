import { createApp } from 'vue'
import App from './App.vue'
import router from './router/index'

const app = createApp(App);
app.use(router); // Usa el enrutador en la aplicación principal
app.mount('#app');
