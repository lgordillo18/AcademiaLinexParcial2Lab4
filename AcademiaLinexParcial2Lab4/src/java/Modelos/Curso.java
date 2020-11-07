/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author User
 */
public class Curso {
    private int id;
    private String nombre;
    private double precio;
    private int tipoTurnoId;
    private int tipoCursoId;

    public Curso(String nombre, double precio, int tipoTurnoId, int tipoCursoId) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoTurnoId = tipoTurnoId;
        this.tipoCursoId = tipoCursoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTipoTurnoId() {
        return tipoTurnoId;
    }

    public void setTipoTurnoId(int tipoTurnoId) {
        this.tipoTurnoId = tipoTurnoId;
    }

    public int getTipoCursoId() {
        return tipoCursoId;
    }

    public void setTipoCursoId(int tipoCursoId) {
        this.tipoCursoId = tipoCursoId;
    }
    
    
}
