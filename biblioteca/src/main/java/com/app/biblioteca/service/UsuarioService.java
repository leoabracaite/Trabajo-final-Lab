package com.app.biblioteca.service;

import com.app.biblioteca.model.Libro;
import com.app.biblioteca.model.Usuario;
import com.app.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> obtenerUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario registrarUsuario(Usuario nuevoUsuario){
        return usuarioRepository.save(nuevoUsuario);
    }

    public Usuario usuarioPorId(Long id){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        return optionalUsuario.get();
    }

    public Usuario modificarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Usuario usuario = new Usuario();
        return usuario;
    }
}
