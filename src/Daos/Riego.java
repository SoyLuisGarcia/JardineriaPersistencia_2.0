/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Daos.Productos;
import java.io.Serializable;
import java.util.List;

public class Riego implements Serializable {

    private Integer id_riego;

    private Integer id_planta;

    private String fecha_riego;

    private Productos Producto;

    public Riego() {
    }

    public Riego(Integer id_planta, Integer id_riego, String fecha_riego) {
        this.id_riego = id_riego;
        this.fecha_riego = fecha_riego;
        this.id_planta = id_planta;
    }

    public Integer getId_riego() {
        return id_riego;
    }

    public void setId_riego(Integer id_riego) {
        this.id_riego = id_riego;
    }

    public Integer getId_planta() {
        return id_planta;
    }

    public void setId_planta(Integer id_planta) {
        this.id_planta = id_planta;
    }

    public String getFecha_riego() {
        return fecha_riego;
    }

    public void setFecha_riego(String fecha_riego) {
        this.fecha_riego = fecha_riego;
    }

    public Productos getProducto() {
        return Producto;
    }

    public void setProducto(Productos producto) {
        Producto = producto;
    }

}
