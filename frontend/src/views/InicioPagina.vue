<template>
  <div class="inicio-pagina">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      <div class="container-fluid">
        <a class="navbar-brand">Sistema de Graduados UCB</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <router-link class="nav-link active" to="/">Inicio</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/instructivo">
                <i class="bi bi-book"></i> Instructivo
              </router-link>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="https://lpz.ucb.edu.bo/usei/" target="_blank">USEI</a>
            </li>
            <!-- In the navbar section -->
            <li class="nav-item">
              <router-link class="nav-link" to="/auth/login">
                <i class="bi bi-person"></i> Login
              </router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Hero Section -->
    <div class="hero-section">
      <div class="overlay"></div>
      <img :src="imagen1" class="hero-image" alt="UCB Campus">
      <div class="hero-content">
        <h1>Sistema de Gestión de Graduados UCB</h1>
        <p class="lead">
          Plataforma integral para el seguimiento y conexión con graduados de la Universidad Católica Boliviana
        </p>
        <div class="hero-buttons">
          <router-link to="/auth/login" class="btn btn-light btn-lg me-3">
            <i class="bi bi-person"></i> Acceso Administrativo
          </router-link>
          <router-link to="/registro" class="btn btn-outline-light btn-lg">
            <i class="bi bi-mortarboard"></i> Registro de Graduados
          </router-link>
        </div>
      </div>
    </div>

    <!-- Features Section -->
    <div class="features-section">
      <div class="container">
        <h2 class="section-title">Funcionalidades del Sistema</h2>
        <div class="row g-4">
          <div class="col-md-4">
            <div class="feature-card">
              <i class="bi bi-people-fill"></i>
              <h3>Gestión de Graduados</h3>
              <p>Base de datos centralizada con información actualizada de todos los graduados UCB</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="feature-card">
              <i class="bi bi-graph-up"></i>
              <h3>Análisis y Reportes</h3>
              <p>Generación de estadísticas y reportes sobre el desarrollo profesional de graduados</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="feature-card">
              <i class="bi bi-search"></i>
              <h3>Búsqueda Avanzada</h3>
              <p>Localización rápida de graduados por carrera, año, especialidad y más</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Admin Benefits Section -->
    <div class="benefits-section">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-6">
            <img :src="imagen2" class="rounded shadow-lg img-fluid" alt="UCB Gestión">
          </div>
          <div class="col-md-6">
            <h2>Herramientas Administrativas</h2>
            <ul class="feature-list">
              <li><i class="bi bi-check-circle-fill"></i> Seguimiento detallado de graduados por carrera</li>
              <li><i class="bi bi-check-circle-fill"></i> Generación de reportes estadísticos</li>
              <li><i class="bi bi-check-circle-fill"></i> Sistema de contacto directo</li>
              <li><i class="bi bi-check-circle-fill"></i> Control de actualizaciones de información</li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <!-- Stats Section -->
    <div class="stats-section">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-4">
            <div class="stat-card">
              <i class="bi bi-mortarboard"></i>
              <h3>Graduados Registrados</h3>
              <p class="stat-number">5000+</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="stat-card">
              <i class="bi bi-building"></i>
              <h3>Carreras</h3>
              <p class="stat-number">20+</p>
            </div>
          </div>
          <div class="col-md-4">
            <div class="stat-card">
              <i class="bi bi-calendar-check"></i>
              <h3>Años de Trayectoria</h3>
              <p class="stat-number">50+</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Footer -->
    <footer class="bg-primary text-white text-center text-lg-start mt-5">
      <div class="container p-4">
        <div class="row">
          <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
            <h5 class="text-uppercase">Contacto</h5>
            <p>
              Puedes contactarnos a través de las siguientes plataformas:
            </p>
          </div>
          <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
            <a href="mailto:useilpz@ucb.edu.bo" class="btn btn-outline-light btn-floating m-1">
              <i class="bi bi-envelope"></i>
            </a>
            <a>useilpz@ucb.edu.bo</a>
            <a href="https://m.facebook.com/people/Usei-La-Paz/100086697512202/" class="btn btn-outline-light btn-floating m-1" target="_blank">
              <i class="bi bi-facebook"></i>
            </a>
            <a href="https://www.instagram.com/usei.lapaz/" class="btn btn-outline-light btn-floating m-1" target="_blank">
              <i class="bi bi-instagram"></i>
            </a>
            <a href="https://bo.linkedin.com/in/usei-la-paz-080327253" class="btn btn-outline-light btn-floating m-1" target="_blank">
              <i class="bi bi-linkedin"></i>
            </a>
            <a href="tel:+59175488476" class="btn btn-outline-light btn-floating m-1">
              <i class="bi bi-telephone"></i>
            </a>
          </div>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
import imagen1 from '../assets/imagen1.jpeg'
import imagen2 from '../assets/imagen2.jpeg'
import imagen3 from '../assets/imagen3.jpeg'

export default {
  name: 'InicioPagina',
  data() {
    return {
      imagen1,
      imagen2,
      imagen3
    }
  }
}
</script>

<style scoped>
.inicio-pagina {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

.hero-section {
  position: relative;
  height: 80vh;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  text-align: center;
}

.hero-image {
  position: absolute;
  width: 100%;
  height: 100%;
  object-fit: cover;
  z-index: 1;
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.6);
  z-index: 2;
}

.hero-content {
  position: relative;
  z-index: 3;
  max-width: 800px;
  padding: 2rem;
}

.hero-content h1 {
  font-size: 3.5rem;
  margin-bottom: 1.5rem;
  font-weight: bold;
}

.hero-content .lead {
  font-size: 1.5rem;
  margin-bottom: 2rem;
}

.features-section {
  padding: 5rem 0;
  background: #f8f9fa;
}

.feature-card {
  background: white;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;
  height: 100%;
}

.feature-card:hover {
  transform: translateY(-10px);
}

.feature-card i {
  font-size: 2.5rem;
  color: #0056b3;
  margin-bottom: 1.5rem;
}

.feature-card h3 {
  color: #2c3e50;
  margin-bottom: 1rem;
}

.benefits-section {
  padding: 5rem 0;
  background: white;
}

.feature-list {
  list-style: none;
  padding: 0;
}

.feature-list li {
  padding: 1.2rem;
  background: rgba(0, 86, 179, 0.1);
  border-radius: 8px;
  margin-bottom: 1rem;
  font-size: 1.1rem;
  display: flex;
  align-items: center;
}

.feature-list li i {
  color: #0056b3;
  margin-right: 1rem;
  font-size: 1.2rem;
}

.stats-section {
  background: linear-gradient(135deg, #0056b3, #007bff);
  padding: 5rem 0;
  color: white;
}

.stat-card {
  padding: 2rem;
  text-align: center;
}

.stat-card i {
  font-size: 3.5rem;
  margin-bottom: 1.5rem;
}

.stat-number {
  font-size: 3rem;
  font-weight: bold;
  margin-top: 1rem;
}

.section-title {
  text-align: center;
  margin-bottom: 4rem;
  color: #2c3e50;
  font-size: 2.5rem;
  font-weight: bold;
}

.btn-light {
  font-weight: 600;
  padding: 0.8rem 1.5rem;
}

.btn-outline-light {
  font-weight: 600;
  padding: 0.8rem 1.5rem;
}

.navbar {
  background: rgba(0, 86, 179, 0.95) !important;
}

footer {
  margin-top: auto;
  background: #0056b3 !important;
}

.btn-floating {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  margin: 0 5px;
  transition: all 0.3s ease;
}

.btn-floating:hover {
  transform: translateY(-3px);
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
}
</style>