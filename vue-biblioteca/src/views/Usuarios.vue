<template>
    <div class="listaLibros">
        <Tabla :datos="usuarios" :campos="titulos" class="tablaList"></Tabla>
    </div>
</template>
<style scoped>
    .listaLibros{
        background-color: rgb(230, 230, 230);
        overflow: auto;
    }
</style>
<script>
import axios from 'axios';
import { ref, onMounted, watch } from 'vue';
import Tabla from '../components/Tabla.vue';
import { useRoute, useRouter } from 'vue-router';

    export default {
        components: {
            Tabla,    
        },
        setup() {
            const router = useRouter();
            const id = ref('');
            const route = useRoute();
            const usuarios = ref([]);
            const titulos=['Nombre','Legajo','Edad','Direccion','Altura','ID Usuario'];
            onMounted(() => {
                axios.get('http://localhost:8080/api/usuarios/listar')
                .then(response=>{
                    usuarios.value = response.data;

                    console.log(usuarios.value);
                })
                .catch(error=>{
                    console.log('Error:',error);
                });
                eliminarLib();
            });

            const eliminarLib = async () => {
                if (route.params.id != null) {
                    try {
                        if (confirm('¿Estás seguro de eliminar este libro?')) {
                            await axios.delete(`http://localhost:8080/api/usuarios/eliminar/${route.params.id}`);

                            router.replace({ name:'usuarios'});
                        }
                    } catch (error) {
                        alert('NO ES POSIBLE ELIMINAR USUARIOS QUE ESTEN EN PRESTAMO')
                    }
                }
            }
            watch(() => route.params.id, eliminarLib);    
        return {usuarios,titulos,eliminarLib};
        },
    }

</script>