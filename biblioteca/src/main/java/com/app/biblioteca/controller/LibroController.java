package com.app.biblioteca.controller;

import com.app.biblioteca.model.*;
import com.app.biblioteca.service.AutorService;
import com.app.biblioteca.service.Libros_autorService;
import com.app.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final AutorService autorService;
    private final LibroService libroService;

    private final Libros_autorService libros_autorService;
    @Autowired
    public LibroController(LibroService _libroService, AutorService autorService, Libros_autorService libros_autorService){
        this.autorService=autorService;
        this.libroService=_libroService;
        this.libros_autorService=libros_autorService;
    }

    @GetMapping("/listar")
    public List<LibroAD> obtenerLibros(){
        return libroService.librosConAyG();
    }


    @GetMapping("/listarSinPrestamo")
    public List<Libro> obtenerLibrosSinPres(){
        return libroService.obtenerLibrosSinPres();
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarLibro(@PathVariable Long id){
        libroService.eliminarLibro(id);
    };


    @PostMapping("/registrar")
    public Libro crearLibro(@RequestBody AutorAuxiliar autorAuxiliar) {

        Autor autor = autorService.autorPorId(autorAuxiliar.getIdAutor());

        Libro nuevoLibro = new Libro();
        nuevoLibro.setTitulo(autorAuxiliar.getTitulo());
        nuevoLibro.setNro_pags(autorAuxiliar.getNroPags());
        nuevoLibro.setSinopsis(autorAuxiliar.getSinopsis());
        nuevoLibro.setPrimer_genero(autorAuxiliar.getGenero1());
        nuevoLibro.setSegundo_genero(autorAuxiliar.getGenero2());
        nuevoLibro.setTercer_genero(autorAuxiliar.getGenero3());

        Libro l = libroService.crearLibro(nuevoLibro);

        Libros_Autor libros_autor = new Libros_Autor();
        libros_autor.setLibro(l);
        libros_autor.setAutor(autor);
        libros_autorService.crearLibros_autor(libros_autor);
        return l;
    }


    @PostMapping("/modificar")
    public Libro modificarLibro(@RequestBody AutorAuxiliar autorAuxiliar){
        return libroService.modificarLibro(autorAuxiliar);
    }
    @GetMapping("/listarDispo")
    public List<Libro> obtenerLibDispo(){
        return libroService.obtenerLibDispo();
    }

    @GetMapping("listarPorTit/{tit}")
    public List<LibroAD> listarPortit(@PathVariable String tit){
        return libroService.listarPortit(tit);
    }

}