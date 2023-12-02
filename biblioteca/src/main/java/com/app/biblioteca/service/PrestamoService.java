package com.app.biblioteca.service;

import com.app.biblioteca.model.Libro;
import com.app.biblioteca.model.Prestamo;
import com.app.biblioteca.model.PrestamoAuxiliar;
import com.app.biblioteca.model.Usuario;
import com.app.biblioteca.repository.AutorRepository;
import com.app.biblioteca.repository.LibroRepository;
import com.app.biblioteca.repository.PrestamoRepository;
import com.app.biblioteca.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;

    private final UsuarioRepository usuarioRepository;
    @Autowired
    public PrestamoService(LibroRepository libroRepository,UsuarioRepository usuarioRepository,PrestamoRepository prestamoRepository){
        this.prestamoRepository = prestamoRepository;
        this.usuarioRepository=usuarioRepository;
        this.libroRepository=libroRepository;
    }

    public List<Prestamo> obtenerPrestamos(){
        return prestamoRepository.obtenerPrest();
    }

    public Prestamo crearPrestamo(Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }

    public Prestamo modificarPrestamo(PrestamoAuxiliar prestamoAuxiliar){
        Long idPrestamo = prestamoAuxiliar.getId_prestamo();
        if (idPrestamo == null) {
            throw new IllegalArgumentException("El ID del préstamo no puede ser nulo");
        }


        Prestamo prestamo = prestamoRepository.findById(prestamoAuxiliar.getId_prestamo())
                .orElseThrow(() -> new EntityNotFoundException("Prestamo no encontrado"));

        Libro libro = libroRepository.findById(prestamoAuxiliar.getId_libro())
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado"));

        Usuario usuario = usuarioRepository.findById(prestamoAuxiliar.getId_usuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
        prestamo.setId_prestamo(prestamoAuxiliar.getId_prestamo());
        prestamo.setLibro(libro);
        prestamo.setUsuario(usuario);
        prestamo.setFecha_prestamo(prestamoAuxiliar.getFecha_prestamo());
        prestamo.setDias_prestamo(prestamoAuxiliar.getDias_prestamo());

        return prestamoRepository.save(prestamo);
    }

    public void eliminarPrestamo(Long id){
        try{
            prestamoRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Prestamo obtenerPrestamoPorId(Long id){
        return prestamoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Prestamo no encontrado"));
    }
    @Transactional
    public void actualizarEst(Long idEst){
        prestamoRepository.actualizarEst(idEst);
    }
}