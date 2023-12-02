package com.app.biblioteca.controller;
import com.app.biblioteca.model.Autor;
import com.app.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;
    @Autowired
    public AutorController(AutorService autorService){
        this.autorService=autorService;
    }
    @GetMapping("/listar")
    public List<Autor> obtenerAutores(){
        return autorService.obtenerAutores();
    }

    @PostMapping("/registrar")
    public Autor crearAutor(@RequestBody Autor autor){
        return autorService.crearAutor(autor);
    }


}
