package com.app.biblioteca.controller;

import com.app.biblioteca.model.Usuario;
import com.app.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService _usuarioService){
        this.usuarioService = _usuarioService;
    }
    @GetMapping("/listar")
    public List<Usuario> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    @PostMapping("/registrar")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/modificar")
    public Usuario modificarUsuario(@RequestBody Usuario usuario){
        return usuarioService.modificarUsuario(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public Usuario eliminarUsuario(@PathVariable Long id){
        return usuarioService.eliminarUsuario(id);
    }

}
