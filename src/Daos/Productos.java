/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Daos.Almanaque;
import java.io.Serializable;
import java.util.List;

public class Productos implements Serializable {

    private Integer id;

    private String nombre_planta;

    private String fecha_ingreso;

    private String status;

    private List<Almanaque> Almanaque;
    private List<Tipos> Tipo;
    private List<Riego> Riego;

    public Productos() {
    }

    public Productos(String nombre_planta, String fecha_ingreso, String status) {
        this.nombre_planta = nombre_planta;
        this.fecha_ingreso = fecha_ingreso;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_planta() {
        return nombre_planta;
    }

    public void setNombre_planta(String nombre_planta) {
        this.nombre_planta = nombre_planta;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Almanaque> getAlmanaque() {
        return Almanaque;
    }

    public void setAlmanaque(List<Almanaque> almanaque) {
        Almanaque = almanaque;
    }

    public List<Tipos> getTipo() {
        return Tipo;
    }

    public void setTipo(List<Tipos> tipo) {
        Tipo = tipo;
    }

    public List<Riego> getRiego() {
        return Riego;
    }

    public void setRiego(List<Riego> riego) {
        Riego = riego;
    }

}
