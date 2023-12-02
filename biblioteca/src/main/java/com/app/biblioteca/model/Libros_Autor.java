package com.app.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name="libros_autor")
public class Libros_Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_libros_autor;

    @ManyToOne
    @JoinColumn(name="id_libro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name="id_autor")
    private Autor autor;

    public Libros_Autor(Libro libro, Autor autor) {
        this.libro = libro;
        this.autor = autor;
    }

    public Long getId_libros_autor() {
        return id_libros_autor;
    }

    public void setId_libros_autor(Long id_libros_autor) {
        this.id_libros_autor = id_libros_autor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Libros_Autor() {
    }
}
