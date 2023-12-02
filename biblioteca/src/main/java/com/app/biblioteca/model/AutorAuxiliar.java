package com.app.biblioteca.model;

public class AutorAuxiliar {
    private Long idLibro;
    private String titulo;
    private Long idAutor;
    private int nroPags;
    private String sinopsis;

    private String genero1;
    private String genero2;
    private String genero3;

    private Long idLibrosAutor;
    public AutorAuxiliar(String titulo, Long idAutor, int nroPags, String sinopsis, String genero1, String genero2, String genero3) {
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.nroPags = nroPags;
        this.sinopsis = sinopsis;
        this.genero1=genero1;
        this.genero2=genero2;
        this.genero3=genero3;
    }
    public AutorAuxiliar() {
    }
    public AutorAuxiliar(Long idLibro,String titulo, Long idAutor, int nroPags, String sinopsis) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.idAutor = idAutor;
        this.nroPags = nroPags;
        this.sinopsis = sinopsis;
    }

    public Long getIdLibrosAutor() {
        return idLibrosAutor;
    }

    public void setIdLibrosAutor(Long idLibrosAutor) {
        this.idLibrosAutor = idLibrosAutor;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getGenero1() {
        return genero1;
    }

    public void setGenero1(String genero1) {
        this.genero1 = genero1;
    }

    public String getGenero2() {
        return genero2;
    }

    public void setGenero2(String genero2) {
        this.genero2 = genero2;
    }

    public String getGenero3() {
        return genero3;
    }

    public void setGenero3(String genero3) {
        this.genero3 = genero3;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public int getNroPags() {
        return nroPags;
    }

    public void setNroPags(int nroPags) {
        this.nroPags = nroPags;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
