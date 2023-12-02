import {createRouter,createWebHistory} from 'vue-router'

const router = createRouter({
    history: createWebHistory(),
    routes:[
    {
        path: "/",
        name: "home",
        component: ()=>import('./views/Home.vue')
    },   
    {
        path: "/libros",
        name: "libros",
        component: ()=>import('./views/Libros.vue')
    },
    {
        path: "/libros/registrar",
        name: "regisLibros",
        component: ()=>import('./views/RegisLibros.vue')
    },
    {
        path: "/libros/registrar/autor",
        name: "regisAutor",
        component: ()=>import('./views/RegisAutor.vue')
    },
    
    {
        path:"/usuarios",
        name:"usuarios",
        component: ()=>import('./views/Usuarios.vue')
    },
    {
        path:"/usuarios/registrar",
        name:"regisUsuarios",
        component: ()=>import('./views/RegisUsuarios.vue')
    },
    {
        path:"/usuarios/modificar/:id",
        name:"usuariosModificar",
        props: true,
        component: ()=>import('./views/RegisUsuarios.vue')
    },
    {
        path:"/usuarios/:id",
        name:"usuariosEliminar",
        props: true,
        component: ()=>import('./views/Usuarios.vue')
    },
    {
        path:"/prestamos",
        name:"prestamos",
        component: ()=>import('./views/Prestamos.vue')
    },
    {
        path:"/prestamos/:idEst",
        name:"prestamosEntregado",
        component: ()=>import('./views/Prestamos.vue')
    },
    {
        path:"/prestamos/modificar/:id",
        name:"prestamosModificar",
        props:true,
        component: ()=>import('./views/RegisPrestamos.vue')
    },
    {
        path:"/prestamos/:id",
        name:"prestamosEliminar",
        component: ()=>import('./views/Prestamos.vue')
    },
    {
        path:"/prestamos/registrar",
        name:"regisPrestamos",
        component: ()=>import('./views/RegisPrestamos.vue')
    },
    {
        path:"/libros/modificar/:id",
        name:"librosModificar",
        props:true,
        component: ()=>import('./views/RegisLibros.vue')
    },
    {
        path:"/libros/:id",
        name:"librosEliminar",
        props:true,
        component: ()=>import('./views/Libros.vue')
    }]
});

export default router;