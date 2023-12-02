<template>
    <div class="regisUsu">
        <Formulario :datos="datos" :objPost="objPost"></Formulario>
    </div>
</template>
<script>
import { onMounted, reactive, ref, watch } from 'vue';
import Formulario from '../components/Formulario.vue';
import axios from 'axios';
import { useRoute } from 'vue-router';
    export default {
        components:{
            Formulario,     
        },
        setup(){
            const id = ref('');
            //const objPost=reactive({});
            const route = useRoute();
            const datos = reactive({
                tipDatos:['text','text','number','text','text','text','text'],
                titulos: ['Titulo','Autor','Nro pags','Sinopsis','Genero','2do Genero','3er Genero'],
                //models:['nom','legajo','edad','calle','altura'],
                url:'',
                autores:ref([]),
                idAutores:ref([]),
                generos: ['Aventuras','Biografia','Ciencia ficcion y fantasia','Romance','Educacion y aprendizaje'],
            });

            
            
            const objPost = reactive({
                titulo:'',
                idAutor: null,
                nroPags: null,
                sinopsis:'',
                genero1:'',
                genero2:'',
                genero3:'',
                idLibro: parseInt(route.params.id),
            });


            rellenarAutores();
            function rellenarAutores(){
                
                axios.get('http://localhost:8080/api/autores/listar')
                .then(response=>{
                    const autoresDat=response.data;
                    datos.autores.value = autoresDat.map(autor =>autor.nombre);
                    datos.idAutores.value = autoresDat.map(idAut => idAut.id_autor);
                    //console.log(datos.idAutores.value);
                })
                .catch(error=>{
                    console.log('Error:',error);
                })     
            }

            const cambiarUrl = async()=>{
                if(route.params.id != null){
                    datos.url= 'http://localhost:8080/api/libros/modificar';
                    //Object.assign(objPost, obMod);
                }else{
                    datos.url= 'http://localhost:8080/api/libros/registrar';
                    //Object.assign(objPost, obRegis);
                };        
                console.log(datos.url);
            }
            
            onMounted(()=>{
                id.value = route.params.id;
                cambiarUrl();
            });
            
            watch(() => route.params.id, cambiarUrl);
            return {datos, objPost,id,cambiarUrl};
        }
    }
</script>      
<style scoped>
.regisUsu{

    width: 60%;
    height: 60%;
}

</style>       