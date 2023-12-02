<template>
    <table>
        <thead>
            <tr>
                <th v-for="element in campos" :key="element">{{element}}</th>
                <th class="elimMod"></th>
            </tr>
        </thead> 
        <tr v-for="(dato,filaIndex) in datos" :key="filaIndex" :class="{ 'fila-deshabilitada': dato.estado }">
            <td v-for="(val,colIndex) in dato" :key="colIndex">        
                <ul v-if="typeof val === 'object'">
                   <li v-for="(elem, i) in val" :key="i">{{ elem }}</li>
                </ul>
                <span v-else>{{ val }}</span>
            </td>
              
            <td class="elimMod">
                <router-link :to="{name:'librosModificar', params:{id:dato.id_libro}}" class="alink" v-if="dato.hasOwnProperty('id_libro')">Modificar</router-link><br>
                <router-link :to="{name:'usuariosModificar', params:{id:dato.idUsuario}}" class="alink" v-if="dato.hasOwnProperty('legajo')">Modificar</router-link><br>
                <router-link :to="{name:'prestamosModificar', params:{id:dato.id_prestamo}}" class="alink" v-if="dato.hasOwnProperty('id_prestamo') && !dato.estado ">Modificar</router-link><br>
                
                <router-link :to="{name:'prestamosEntregado', params:{idEst:dato.id_prestamo}}" class="alink" v-if="dato.hasOwnProperty('id_prestamo') && !dato.estado ">Marcar como entregado</router-link><br>
           
                <router-link :to="{name:'librosEliminar', params:{id:dato.id_libro}}" class="alink" v-if="dato.hasOwnProperty('id_libro')">Eliminar</router-link><br>
                <router-link :to="{name:'usuariosEliminar', params:{id:dato.idUsuario}}" class="alink" v-if="dato.hasOwnProperty('legajo')">Eliminar</router-link><br>
                <router-link :to="{name:'prestamosEliminar', params:{id:dato.id_prestamo}}" class="alink" v-if="dato.hasOwnProperty('id_prestamo') && dato.estado">Eliminar</router-link><br>

            </td>
        </tr>
    </table>
</template>
<script>
import { onMounted,ref } from 'vue';


export default {
    props :{ 
            datos:{
                type: Object,
                required: true,
            },
            campos:{
                type: Array,
                required: true,
            },
        },
    };

    window.addEventListener('scroll', function() {
    const fijarElimMod = document.querySelector('.elimMod');
    const fijarElimModOffsetTop = fijarElimMod.offsetTop;

    if (window > fijarElimModOffsetTop) {
        fijarElimMod.style.top = window - fijarElimModOffsetTop + 'px';
    } else {
        fijarElimMod.style.top = '';
    }
    });
</script>
<style scoped>

    
    .fila-deshabilitada td {
        background-color: lightgreen;
    }

    table{
        display: block;
        position: relative;
        border-collapse: collapse;
    }
    .elimMod{
        position: sticky;
        right: 0;
        background-color: rgb(200, 200, 200);
        
    }
    thead{
        background-color: rgb(200, 200, 200);
        position: sticky;
        z-index: 100;
        top: 0;
    }
    th {

        position: sticky;
        padding: 10px;
        border-bottom: 2px solid white;
    }
    td{
        padding: 25px;
        border-bottom: 2px solid white;
    }

    table tr:hover{
        background-color: rgb(200, 200, 200);
    }
    .custom-table .elimMod {
    position: sticky;
    right: 0;
    background-color: rgb(200, 200, 200);
    text-align: center;
  }

  .alink {
    display: block;
    text-align: center;
    text-decoration: none;
    padding: 5px;
    color: #fff;
    background-color: rgb(65, 75, 178);
    border-radius: 4px;
    cursor: pointer;
  }
  .alink:hover{
    background-color: rgb(230, 230, 230);
  }
</style>