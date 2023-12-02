package com.app.biblioteca.model;

import jakarta.persistence.Entity;

public class LibroAD {
    private Long id_libro;
    private String titulo;

    private int nro_pags;
    private String sinopsis;
    private Long id_autor;
    private String nombre;
    private String nacionalidad;
    // private Long id_libro_gen;//probar sacando este
    private String primer_genero;
    private String segundo_genero;
    private String tercer_genero;

    public LibroAD(Long id_libro, String titulo, int nro_pags, String sinopsis, Long id_autor, String nombre, String nacionalidad, String primer_genero, String segundo_genero, String tercer_genero) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.nro_pags = nro_pags;
        this.sinopsis = sinopsis;
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.primer_genero = primer_genero;
        this.segundo_genero = segundo_genero;
        this.tercer_genero = tercer_genero;
    }

    public LibroAD() {}

    public Long getId_libro() {
        return id_libro;
    }

    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNro_pags() {
        return nro_pags;
    }

    public void setNro_pags(int nro_pags) {
        this.nro_pags = nro_pags;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Long getId_autor() {
        return id_autor;
    }

    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPrimer_genero() {
        return primer_genero;
    }

    public void setPrimer_genero(String primer_genero) {
        this.primer_genero = primer_genero;
    }

    public String getSegundo_genero() {
        return segundo_genero;
    }

    public void setSegundo_genero(String segundo_genero) {
        this.segundo_genero = segundo_genero;
    }

    public String getTercer_genero() {
        return tercer_genero;
    }

    public void setTercer_genero(String tercer_genero) {
        this.tercer_genero = tercer_genero;
    }
}
