<template>
    <nav class="menu">
        <span class="alink">{{ opcion.nom }}</span>
        <ul class="submenu">
            <li v-for="(elemento, i) in opcion.urls" :key="i">
                <router-link :to="elemento" class="alink">{{opcion.campos[i]}}</router-link>
            </li>
        </ul>
    </nav>
</template>
<style scoped>
.menu {
  position: relative;
  display: inline-block;
  list-style: none;
}

.alink {
  display: block;
  color: #fff;
  text-decoration: none;
  padding: 15px;
  cursor: pointer;
  width: 100%;
  text-align: left;
}

.menu:hover .submenu {
  display: block;
}

.submenu {
  display: none;
  position: absolute;
  list-style: none;
  top: 100%;
  left: 0px;
  margin: 0;
  padding: 0;
  background-color: rgb(200, 200, 200);
  z-index: 1;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.submenu li {
  display: block;
  width: 100%;
  text-align: left;
}

.submenu li:hover {
  background-color: rgb(65, 75, 178);
}
</style>

<script>
    export default {
        props: {
            opcion: {
                type: Object,
                required: true
            },
        },
    }
</script>