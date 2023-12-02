package com.app.biblioteca.controller;

import com.app.biblioteca.model.*;
import com.app.biblioteca.service.AutorService;
import com.app.biblioteca.service.LibroService;
import com.app.biblioteca.service.PrestamoService;
import com.app.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private PrestamoService prestamoService;
    private UsuarioService usuarioService;

    private LibroService libroService;
    @Autowired
    public PrestamoController(PrestamoService prestamoService, UsuarioService usuarioService,LibroService libroService){
        this.usuarioService=usuarioService;
        this.prestamoService=prestamoService;
        this.libroService=libroService;
    }

    @GetMapping("/listar/{id}")
    public Prestamo obtenerPrestamoPorId(@PathVariable Long id){
        return prestamoService.obtenerPrestamoPorId(id);
    }
    @GetMapping("/listar")
    public List<Prestamo> obtenerPrestamos(){
        return prestamoService.obtenerPrestamos();
    }

    @PostMapping("/registrar")
    public Prestamo crearPrestamo(@RequestBody PrestamoAuxiliar prestamoAuxiliar){
        Usuario usuario = usuarioService.usuarioPorId(prestamoAuxiliar.getId_usuario());

        Libro libro = libroService.libroPorId(prestamoAuxiliar.getId_libro());

        Prestamo prestamo = new Prestamo(prestamoAuxiliar.getFecha_prestamo(),prestamoAuxiliar.getDias_prestamo(), false);

        prestamo.setLibro(libro);
        prestamo.setUsuario(usuario);

        return prestamoService.crearPrestamo(prestamo);
    }

    @PostMapping("/modificar")
    public Prestamo modificarPrestamo(@RequestBody PrestamoAuxiliar prestamoAuxiliar){
        return prestamoService.modificarPrestamo(prestamoAuxiliar);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarPrestamo(@PathVariable Long id){
        prestamoService.eliminarPrestamo(id);
    }

    @PostMapping("/actualizarEst/{idEst}")
    public void actualizarEst(@PathVariable Long idEst){
        prestamoService.actualizarEst(idEst);
    }

}
