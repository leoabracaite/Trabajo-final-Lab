<template>
    <div class="listaLibros">
        <Tabla :datos="prestamos" :campos="titulos"></Tabla>
    </div>
</template>
<style scoped>
    .listaLibros{
        max-width: 90%;
        max-height: 80%;
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
            const idEst = ref('');
            const id = ref('');
            const route = useRoute();
            const prestamos = ref([]);
            const titulos=['ID prestamo','Usuario','Libro','Fecha de inicio','Dias de prestamo','Estado'];
            onMounted(() => {
                axios.get('http://localhost:8080/api/prestamos/listar')
                .then(response=>{
                    prestamos.value = response.data;
                })
                .catch(error=>{
                    console.log('Error:',error);
                });
            });
            const eliminarLib = async () => {
                if (route.params.id != null) {
                    //console.log("hp;awda");
                    try {
                        if (confirm('¿Estás seguro de eliminar este prestamo?')) {
                            await axios.delete(`http://localhost:8080/api/prestamos/eliminar/${route.params.id}`);
                        }
                    } catch (error) {
                        alert('NO ES POSIBLE ELIMINAR El PRESTAMO')
                    }
                }
            }

            const actualiEst = async()=>{
                if(route.params.idEst != null){
                    try {
                        if (confirm('¿Estás seguro de actualizar el estado de este prestamo?')) {
                            await axios.post(`http://localhost:8080/api/prestamos/actualizarEst/${route.params.idEst}`);

                            router.replace({ name:'prestamos'});
                        }
                    } catch (error) {
                        alert('NO ES POSIBLE ACTUALIZAR El ESTADO')
                    }
                }
            }
            watch(() => route.params.id, eliminarLib);    

            watch(() => route.params.idEst, actualiEst);

            return {prestamos,titulos,eliminarLib,actualiEst};
        },
    }

</script>