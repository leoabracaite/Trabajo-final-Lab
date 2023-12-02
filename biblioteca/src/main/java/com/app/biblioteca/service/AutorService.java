package com.app.biblioteca.service;

import com.app.biblioteca.model.Autor;
import com.app.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository){
        this.autorRepository=autorRepository;
    }

    public List<Autor> obtenerAutores(){
        return autorRepository.findAll();
    }

    public Autor crearAutor(Autor nuevoAutor){
        return autorRepository.save(nuevoAutor);
    }

    public Autor autorPorId(Long id){
        Optional<Autor> optionalAutor= autorRepository.findById(id);
        return optionalAutor.get();
    }
}
