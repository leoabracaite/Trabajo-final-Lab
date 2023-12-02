package com.app.biblioteca.service;

import com.app.biblioteca.repository.Libros_autorRepository;
import com.app.biblioteca.model.Libros_Autor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Libros_autorService {
    private final Libros_autorRepository librosAutorRepository;

    @Autowired
    public Libros_autorService(Libros_autorRepository librosAutorRepository){
        this.librosAutorRepository=librosAutorRepository;
    }

    @Transactional
    public Libros_Autor crearLibros_autor(Libros_Autor libros_autor){
        return librosAutorRepository.save(libros_autor);
    }
}
