<template>
  <nav>
    <ul class="navbar">
      <li>   
        <router-link to="/" class="link">Home</router-link>
      </li>
      <li v-for="element in op" :key="element">
        <Opcion :opcion="element"></Opcion>
      </li>  
    </ul>
    <div class="ventanas">
      <router-view/>
    </div>
  </nav>  
</template>
<script>
import { ref, reactive } from 'vue';
import Opcion from './components/Opcion.vue';

class Opciones{
 constructor(_urls, _nom, _campos){
    this.urls = _urls;
    this.nom = _nom;
    this.campos = _campos;
 }
}

export default {
 components:{
    Opcion,
 },
 setup() {
    const op = ref([]);

    const libros = reactive(new Opciones(['/libros','/libros/registrar','/libros/registrar/autor'],'Libros',['Listar libros','Registrar','Registrar autor']));
    const usuarios = reactive(new Opciones(['/usuarios','/usuarios/registrar'],'Usuarios',['Listar usuarios','Registrar']));
    const prestamo = reactive(new Opciones(['/prestamos','/prestamos/registrar'],'Prestamos',['Listar prestamos','Registrar']));

    op.value.push(libros,usuarios,prestamo);
    //console.log(op.value[1].nom[0]);

    return { op, libros, usuarios, prestamo };
 }
};
</script>

<!--
<script>
import Opcion from './components/Opcion.vue';

class Opciones{
  constructor(_urls, _nom, _contOp){
    this.urls = _urls;
    this.nom = _nom;
    this.cantOp = _contOp;
  }
}

export default {
  components:{
    Opcion,
  },
  data() {
    return {
      op:[],
      Home:{
        urls: ['/'],
        nom: ['Home'],
      },
      Libros:{
        urls: ['/libros','/libros/registrar'],
        nom: ['Libros','Registrar'],
      },
    };
  },
  mounted() {
    const home=new Opciones(['/'],['Home'],0);
    const libros=new Opciones(['/libros'],['Libros','Registrar'],2);
    const usuarios=new Opciones(['/usuarios'],'Usuarios',2);
    const prestamo=new Opciones(['/prestamos'],'Prestamo',2);

    this.op.push(home,libros,usuarios,prestamo);
    console.log(this.op[1].nom[0]);
  }
};
</script>
-->

<style scoped>
.link{
  color: #fff;
  text-decoration: none;
  cursor: pointer;
  width: 100%;
  height: 100%;
  padding: 15px;
}
.ventanas{
  width: 100%;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
}

.navbar{
  position: fixed;
  z-index: 500;
  background-color: rgb(65, 75, 178);
  display: flex;
  flex-direction: row;
  list-style: none;
  width: 100%;
  align-items: center;
  justify-content: center;
  margin: 0;
  padding: 0;
}

</style>