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
                tipDatos:['text','text'],
                titulos: ['Nombre y Apellido','Nacionalidad'],
                url:'http://localhost:8080/api/autores/registrar',
            });

            const objPost = reactive({
                nombre:'',
                nacionalidad:'',
            })
                    
            return {datos, objPost};
        }
    }
</script>      
<style scoped>
.regisUsu{

    width: 60%;
    height: 60%;
}

</style> 