<template>
    <div class="formContainer">
    <form @submit.prevent="postData" class="formStyle">
        <table>
            <tr  v-for="(dato,i) in datos.titulos" :key="i">
                <td>
                    <span>{{dato}}</span>
                    <input :type="datos.tipDatos[i]" :placeholder="dato" v-model="valores[i]" v-if="dato!='Usuario' && dato!='Libro' && dato!='Autor' && dato!='Genero' && dato!='2do Genero' && dato!='3er Genero'" required>
                    



                    <!--Aca van los select de registrar prestamo-->
                    <select v-model="valores[i]" v-if="datos.hasOwnProperty('usuarios') && i==0 && band" required>
                        <option :value="usu" v-for="(usu,e) in datos.idUsuarios.value" :key="e"> {{usu}}|{{datos.usuarios.value[e]}}</option>
                    </select>

                    <select v-model="valores[i]" v-if="datos.hasOwnProperty('libros') && i==1 && band" required>
                        <option :value="lib" v-for="(lib,e) in datos.idLibros.value" :key="e"> {{lib}}|{{datos.libros.value[e]}}</option>
                    </select>    




                    
                    <!--Aca los select de modificar prestamo-->
                    <select v-model="valores[i]" v-if="datos.hasOwnProperty('usuarios') && i==0 && !band" required>
                        <option :value="datos.idUsuarios.value"> {{datos.idUsuarios.value}}</option>
                    </select>

                    <select v-model="valores[i]" v-if="datos.hasOwnProperty('libros') && i==1 && !band" required>
                        <option :value="datos.idLibros.value"> {{datos.idLibros.value}}</option>
                    </select>       
                    
                    <!--Estos son los select de libro-->

                    <select v-model="valores[i]" v-if="datos.hasOwnProperty('autores') && i==1" required>
                        <option :value="aut" v-for="(aut,e) in datos.idAutores.value" :key="e"> {{aut}}|{{datos.autores.value[e]}}</option>
                    </select>
                    <select v-model="valores[i]" v-if="datos.hasOwnProperty('autores') && i==4" required>
                        <option :value="gen" v-for="gen in datos.generos" :key="gen">{{gen}}</option>
                    </select>
                    <select v-model="valores[i]" v-if="datos.hasOwnProperty('autores') && i==5" required>
                        <option :value="gen" v-for="gen in datos.generos" :key="gen">{{gen}}</option>
                    </select>
                    <select v-model="valores[i]" v-if="datos.hasOwnProperty('autores') && i==6">
                        <option :value="gen" v-for="gen in datos.generos" :key="gen">{{gen}}</option>
                    </select>
                </td>
            </tr>
        </table>
        
        <input type="submit">
    </form>
    </div>
</template>
<script>
import axios from 'axios';
import { reactive, ref, watch, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

export default {
    
    props: {
        datos:{
            type: Object,
            required: true,
        },  
        objPost:{
            type: Object,
            required: true,
        },    
    },
    setup(props) {
        const router = useRouter();
        const id = ref('');
        const route = useRoute();
        const valores = ref([]);
        const band=ref(Boolean);
        console.log(props.objPost.id_prestamo);
        const postData = async()=>{
            for (let i = 0; i < valores.value.length; i++) {
                const val = Object.keys(props.objPost)[i];
                const element = valores.value[i];
                props.objPost[val] = element;
            }
            console.log(props.objPost);
            try {
                console.log(props.objPost);
                await axios.post(props.datos.url,props.objPost);
                
            } catch (error) {
                console.log('Error:',error);
            }
            router.replace({ name:'home'});
        }    

        const cambiarPres = async()=>{
            if(route.params.id!=undefined){
                band.value=false;
            }else{
                band.value=true;
            }
        }
        onMounted(()=>{
            id.value = route.params.id;
            cambiarPres();
        });
        watch(()=>route.params.id, cambiarPres);
        return{valores, postData, cambiarPres, band};
    },
    
}

</script>
<style scoped>
  .formContainer {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: white;
  }

  .formStyle {
    padding: 20px;
    border-radius: 8px;
    display: flex;
    flex-direction: column;
    align-items: center;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  }

  table {
    width: 100%;
  }

  td {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 10px;
  }

  span {
    cursor: pointer;
    }

  input, select {
    width: 70%; 
    padding: 8px;
    margin-left: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  input[type="submit"] {
    width: 50%; 
    background-color: rgb(65, 75, 178);
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }

  input[type="submit"]:hover {
    background-color: #777;
  }
</style>