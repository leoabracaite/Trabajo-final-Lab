package com.app.biblioteca.model;


import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String nombre;
    private int legajo;
    private int edad;
    private String direc_calle;
    private int direc_altura;

    public Usuario(String nombre, int legajo, int edad, String direc_calle, int direc_altura) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.edad = edad;
        this.direc_calle = direc_calle;
        this.direc_altura = direc_altura;
    }

    public Usuario() {
    }

    public Long getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.id_usuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDirec_calle() {
        return direc_calle;
    }

    public void setDirec_calle(String direc_calle) {
        this.direc_calle = direc_calle;
    }

    public int getDirec_altura() {
        return direc_altura;
    }

    public void setDirec_altura(int direc_altura) {
        this.direc_altura = direc_altura;
    }
}
