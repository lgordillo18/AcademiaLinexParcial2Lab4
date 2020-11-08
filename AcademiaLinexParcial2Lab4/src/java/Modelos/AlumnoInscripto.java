/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class AlumnoInscripto {
    private int id;
    private int idAlumno;
    private int idCurso;
    private int descuento;
    private String fechaInscripcion;

    public AlumnoInscripto(int idAlumno, int idCurso, int descuento) {
        this.idAlumno = idAlumno;
        this.idCurso = idCurso;
        this.descuento = descuento;
        this.fechaInscripcion = this.getFechaActual();
    }
    
    public String getFechaActual() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        
        return formato.format(date);
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    
    
}
