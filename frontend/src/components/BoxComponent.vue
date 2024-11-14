<template>
  <div v-if="isVisible" class="box" @click="navigate">
    <h3 :class="{ admin: isAdmin }">{{ title }}</h3>
  </div>
</template>

<script>
export default {
  props: {
    title: String,
    adminOnly: {
      type: Boolean,
      default: false,
    },
    isAdmin: {
      type: Boolean,
      default: false,
    },
    route: {
      type: String,
      default: "/",
    },
  },
  computed: {
    isVisible() {
      return this.isAdmin || !this.adminOnly;
    },
  },
  methods: {
    navigate() {
      this.$router.push(this.route);
      
    },
  },
};
</script>

<style scoped>
.box {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100px;
  margin: 10px;
  border: 1px solid #ddd;
  border-radius: 8px;
  text-align: center;
  cursor: pointer;
  transition: all 0.3s ease;
  background-color: #f9f9f9;
}

.box:hover {
  box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.15);
  transform: translateY(-5px);
}

.box h3 {
  margin: 0;
  font-size: 18px;
}

.box h3.admin {
  color: rgb(0, 0, 0);
}
</style>
