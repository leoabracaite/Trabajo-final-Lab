package com.app.biblioteca.model;

import java.util.Date;

public class PrestamoAuxiliar {

    private Long id_prestamo;
    private Long id_usuario;
    private Long id_libro;
    private Date fecha_prestamo;
    private int dias_prestamo;

    private boolean estado;

    public PrestamoAuxiliar(Long id_usuario, Long id_libro, Date fecha_prestamo, int dias_prestamo, boolean estado) {
        this.id_usuario = id_usuario;
        this.id_libro = id_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.dias_prestamo = dias_prestamo;
        this.estado=estado;
    }

    public PrestamoAuxiliar(Long id_prestamo,Long id_usuario, Long id_libro, Date fecha_prestamo, int dias_prestamo, boolean estado) {
        this.id_prestamo=id_prestamo;
        this.id_usuario = id_usuario;
        this.id_libro = id_libro;
        this.fecha_prestamo = fecha_prestamo;
        this.dias_prestamo = dias_prestamo;
        this.estado=estado;
    }
    public PrestamoAuxiliar() {}

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Long id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_libro() {
        return id_libro;
    }

    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
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
