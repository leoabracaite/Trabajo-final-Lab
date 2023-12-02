<template>
    <div class="regisUsu">
        <Formulario :datos="datos" :objPost="objPost"></Formulario>
    </div>
</template>
<script>
import { reactive, ref, watch, onMounted } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';
import Formulario from '../components/Formulario.vue';
    export default {
        components:{
            Formulario,     
        },
        setup(){
            const id = ref('');
            const route = useRoute();

            const datos = reactive({
                tipDatos:['text','text','date','number'],
                titulos: ['Usuario','Libro','Fecha de incio del prestamo','Dias de prestamo'],
                libros:ref([]),
                idLibros:ref([]),
                usuarios:ref([]),
                idUsuarios:ref([]),
                url:'',

                //id_libro
            });

            const objPost = reactive({
                id_usuario: null,
                id_libro: null,
                fecha_prestamo: null,
                dias_prestamo:'',
                id_prestamo:parseInt(route.params.id),
                estado:null,
            })

            rellenarDat();
            function rellenarDat(){
                console.log(route.params.id);
                if(route.params.id!=undefined){
                    axios.get(`http://localhost:8080/api/prestamos/listar/${route.params.id}`)
                        .then(response=>{
                            const presDat=response.data;
                            datos.usuarios.value = presDat.usuario.nombre;
                            datos.idUsuarios.value = presDat.usuario.idUsuario;
                            
                            datos.libros.value = presDat.libro.titulo;
                            datos.idLibros.value = presDat.libro.id_libro;
                        })
                        .catch(error=>{
                            console.log('Error:',error);
                        })     
                }else{
                    axios.get('http://localhost:8080/api/libros/listarSinPrestamo')
                        .then(response=>{
                            const libDat=response.data;
                            datos.libros.value = libDat.map(lib=>lib.titulo);
                            datos.idLibros.value = libDat.map(idLib => idLib.id_libro);
                        })
                        .catch(error=>{
                            console.log('Error:',error);
                        })     

                    axios.get('http://localhost:8080/api/usuarios/listar')
                        .then(response=>{
                            const usuDat=response.data;
                            datos.usuarios.value = usuDat.map(usu =>usu.nombre);
                            datos.idUsuarios.value = usuDat.map(idUsu => idUsu.idUsuario);
                        })
                        .catch(error=>{
                            console.log('Error:',error);
                        })  
                }
                
            }

            const cambiarUrl = async()=>{
                if(route.params.id != null){
                    datos.url= 'http://localhost:8080/api/prestamos/modificar';
                }else{
                    datos.url= 'http://localhost:8080/api/prestamos/registrar';
                };        
                console.log(datos.url);
            }
            
            onMounted(()=>{
                id.value = route.params.id;
                cambiarUrl();
            });
            watch(() => route.params.id, rellenarDat);
            watch(() => route.params.id, cambiarUrl);
            return {datos, objPost,cambiarUrl,rellenarDat};
        }
    }
</script>      
<style scoped>
.regisUsu{

    width: 60%;
    height: 60%;
}

</style>                                                                                                                                                  