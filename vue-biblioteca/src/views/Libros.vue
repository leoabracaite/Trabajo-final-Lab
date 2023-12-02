<template>
<div class="libConteiner">
    <div class="buscador">
            <input  v-model="tituBusc" type="text" placeholder="Buscar por titulo" class="tit">
            <input type="button" value="Aplicar" @click="buscarLib()">
    </div>
    <div class="listaLibros">
        <Tabla :datos="libros" :campos="titulos"></Tabla>
    </div>
</div>
</template>
<style scoped>
    .libConteiner{
        width: 100vw;
        height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
    .buscador{
    text-align: center;       
    padding: 10px;
    background-color: white;
    display: inline-block;
    }
    .tit{ 
    padding: 5px;
    margin-right: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    }
    .buscador input[type="button"] {
        text-decoration: none;
        padding: 5px;
        color: #fff;
        background-color: rgb(65, 75, 178);
        border-radius: 4px;
        border: none;
        cursor: pointer;
    }
    .listaLibros{
        max-width: 90%;
        max-height: 70%;
        background-color: rgb(230, 230, 230);
        overflow: auto;
    }
</style>
<script>
import axios from 'axios';
import { ref, onMounted, watch, reactive } from 'vue';
import Tabla from '../components/Tabla.vue';
import { useRoute, useRouter } from 'vue-router';

    export default {
        components: {
            Tabla,    
        },
        setup() {
            const router = useRouter();
            const tituBusc=ref('');
            const id = ref('');
            const route = useRoute();
            const libros = ref([]);
            const titulos=['Id libro','Titulo','Nro. Pags','Sinopsis','Id Autor','Nombre Autor','Nacionalidad Autor','Genero','2do Genero','3er Genero'];
            onMounted(() => {
                id.value = route.params.id;
                
                axios.get('http://localhost:8080/api/libros/listar')
                .then(response=>{
                    libros.value = response.data;
                })
                .catch(error=>{
                    console.log('Error:',error);
                });
                eliminarLib();
            });

            const eliminarLib = async () => {
                if (route.params.id != null) {
                    //console.log("hp;awda");
                    try {
                        if (confirm('¿Estás seguro de eliminar este libro?')) {
                            await axios.delete(`http://localhost:8080/api/libros/eliminar/${route.params.id}`);
                        }
                        router.replace({ name:'libros'});
                    } catch (error) {
                        alert('NO ES POSIBLE ELIMINAR LIBROS QUE ESTEN EN PRESTAMO')
                    }
                }
            }

            const buscarLib=async()=>{
                console.log(tituBusc);
                try{
                    await axios.get(`http://localhost:8080/api/libros/listarPorTit/${tituBusc.value}`)
                        .then(response=>{
                            libros.value = response.data;
                        })
                    }catch(error){
                        alert('NO SE ENCUENTRAN COINCIDENCIAS')   
                    }
            }
            watch(() => route.params.id, eliminarLib);
        return {libros,titulos, eliminarLib, buscarLib, tituBusc};
        },
    }

</script>