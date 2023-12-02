package com.app.biblioteca.service;

import com.app.biblioteca.model.*;
import com.app.biblioteca.repository.AutorRepository;
import com.app.biblioteca.repository.LibroRepository;
import com.app.biblioteca.repository.Libros_autorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final Libros_autorRepository libros_autorRepository;
    @Autowired
    public LibroService(Libros_autorRepository libros_autorRepository,LibroRepository libroRepository, AutorRepository autorRepository){
        this.libros_autorRepository = libros_autorRepository;
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
    }

    public  List<Libro> obtenerLibros(){
        return libroRepository.findAll();
    }


    public Libro crearLibro(Libro libro){
        return  libroRepository.save(libro);
    }


    public int crearLibroManualmente(int nroPags, String sinopsis, String titulo){
        return  libroRepository.saveLibroManualmente(nroPags, sinopsis, titulo);
    }


    public List<LibroAD> librosConAyG(){return libroRepository.librosConAyG();}

    //public Libro eliminarLibro(Long id_libro){

    //}

    public Libro libroPorId(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Libro no encontrado con ID: " + id));
    }

    public List<Libro> obtenerLibDispo(){
        return libroRepository.obtenerLibDispo();
    }
    public Libro modificarLibro(AutorAuxiliar libroMod){
        Libro libro = libroRepository.findById(libroMod.getIdLibro())
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado"));

        libro.setTitulo(libroMod.getTitulo());
        libro.setNro_pags(libroMod.getNroPags());
        libro.setSinopsis(libroMod.getSinopsis());
        libro.setPrimer_genero(libroMod.getGenero1());
        libro.setSegundo_genero(libroMod.getGenero2());
        libro.setTercer_genero(libroMod.getGenero3());


        Autor autor = autorRepository.findById(libroMod.getIdAutor())
                .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado"));

        Libros_Autor libros_autor = libros_autorRepository.buscarPorIdLibroYIdAutor(libroMod.getIdLibro(), libroMod.getIdAutor());

        if (libros_autor == null) {
            libros_autor = new Libros_Autor();
            libros_autor.setAutor(autor);
            libros_autor.setLibro(libro);
        } else {
            libros_autor.setAutor(autor);
            libros_autor.setLibro(libro);
        }

        libros_autorRepository.save(libros_autor);

        /*Genero genero = generoRepository.findById(libroMod.getIdLibro())
                .orElseThrow(() -> new EntityNotFoundException("Id Genero no encontrado"));

        genero.setPrimer_genero(libroMod.getGenero1());
        genero.setSegundo_genero(libroMod.getGenero2());
        genero.setTercer_genero(libroMod.getGenero3());

        generoRepository.save(genero);*/

        return libroRepository.save(libro);
    }

    public void eliminarLibro(Long idLibro) {
        try {
            libroRepository.deleteById(idLibro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Libro> obtenerLibrosSinPres(){
        return libroRepository.obtenerLibrosSinPres();
    }

    public  List<LibroAD> listarPortit(String tit) {
        List<LibroAD> libros = null;
        try {
            libros = libroRepository.listarPortit(tit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libros;
    }
}
