package com.app.biblioteca.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prestamo;

    @OneToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name="id_libro")
    private Libro libro;
    @Column(name = "fecha_prestamo")
    private Date fecha_prestamo;
    @Column(name = "dias_prestamo")
    private int dias_prestamo;

    @Column(name = "estado")
    private boolean estado;

    public Prestamo(Date fecha_prestamo, int dias_prestamo, boolean estado) {
        this.estado=estado;
        this.fecha_prestamo = fecha_prestamo;
        this.dias_prestamo = dias_prestamo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Prestamo() {}

    public Long getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Long id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(Date fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public int getDias_prestamo() {
        return dias_prestamo;
    }

    public void setDias_prestamo(int dias_prestamo) {
        this.dias_prestamo = dias_prestamo;
    }
}
