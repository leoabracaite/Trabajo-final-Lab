<template>
    <div class="regisUsu">
        <Formulario :datos="datos" :objPost="objPost"></Formulario>
    </div>
</template>
<script>
import { reactive, ref, watch, onMounted } from 'vue';
import Formulario from '../components/Formulario.vue';
import { useRoute } from 'vue-router';
    export default {
        components:{
            Formulario,     
        },
        setup(){
            const id=ref('');
            const route = useRoute();
        
            const datos = reactive({
                tipDatos:['text','number','number','text','number'],
                titulos: ['Nombre y Apellido','Legajo','Edad','Calle','Altura'],
                //models:['nom','legajo','edad','calle','altura'],
                url:'',
            });

            const objPost = reactive({
                nombre:'',
                legajo: null,
                edad: null,
                direc_calle:'',
                direc_altura:null,
                idUsuario: parseInt(route.params.id),
            })

            const cambiarUrl = async()=>{
                if(route.params.id != null){
                    datos.url= 'http://localhost:8080/api/usuarios/modificar';
                    //console.log('aogbaog');
                }else{
                    datos.url= 'http://localhost:8080/api/usuarios/registrar';
                };        
                console.log(datos.url);
            }
            
            onMounted(()=>{
                id.value = route.params.id;
                cambiarUrl();
            });
            
            watch(() => route.params.id, cambiarUrl);            
            return {datos, objPost, id, cambiarUrl};
        }
    }
</script>      
<style scoped>
.regisUsu{

    width: 60%;
    height: 60%;
}

</style>                                                                                                                                                  