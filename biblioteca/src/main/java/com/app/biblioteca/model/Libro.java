package com.app.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro", insertable = false, updatable = false)
    private Long id_libro;

    @Column(name = "titulo")
    private String titulo;
    //private String autor;
    @Column(name = "nro_pags")
    private int nro_pags;
    @Column(name = "sinopsis")
    private String sinopsis;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Libros_Autor> autores;

    @Column(name = "primer_genero")
    private String primer_genero;
    @Column(name = "segundo_genero")
    private String segundo_genero;
    @Column(name = "tercer_genero")
    private String tercer_genero;
    public Libro(String titulo, int nro_pags, String sinopsis, String primer_genero,String segundo_genero, String tercer_genero) {
        this.id_libro=null;
        this.titulo = titulo;
        this.nro_pags = nro_pags;
        this.sinopsis = sinopsis;
        this.primer_genero=primer_genero;
        this.segundo_genero=segundo_genero;
        this.tercer_genero=tercer_genero;
    }

    public Libro(Long id_libro, String titulo, int nro_pags, String sinopsis) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.nro_pags = nro_pags;
        this.sinopsis = sinopsis;
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

    public List<Libros_Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Libros_Autor> autores) {
        this.autores = autores;
    }

    public Libro() {
    }
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

    //public String getAutor() {
    //return autor;
    //}

    //public void setAutor(String autor) {
    //  this.autor = autor;
    //}

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
}