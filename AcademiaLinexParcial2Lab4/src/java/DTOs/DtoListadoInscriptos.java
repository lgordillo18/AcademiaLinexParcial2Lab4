/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

/**
 *
 * @author User
 */
public class DtoListadoInscriptos {
    private int codigoInscripcion;
    private String nombreAlumno;
    private String nombreCurso;
    private String fechaInscripcion;

    public DtoListadoInscriptos(int codigoInscripcion, String nombreAlumno, String nombreCurso, String fechaInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
        this.nombreAlumno = nombreAlumno;
        this.nombreCurso = nombreCurso;
        this.fechaInscripcion = fechaInscripcion;
    }

    public int getCodigoInscripcion() {
        return codigoInscripcion;
    }

    public void setCodigoInscripcion(int codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    
}
