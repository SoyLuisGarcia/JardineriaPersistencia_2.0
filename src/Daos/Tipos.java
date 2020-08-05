/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Daos.Productos;
import java.io.Serializable;
import java.util.List;

public class Tipos implements Serializable {

    private Integer id_planta;

    private Integer id_tipo;

    private String tipo;

    private String nombre_tipo;

    private Productos Producto;

    public Tipos() {
    }

    public Tipos(Integer id_planta, String tipo, String nombre_tipo) {
        this.id_planta = id_planta;
        this.tipo = tipo;
        this.nombre_tipo = nombre_tipo;
    }

    public Integer getId_planta() {
        return id_planta;
    }

    public void setId_planta(Integer id_planta) {
        this.id_planta = id_planta;
    }

    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public Productos getProducto() {
        return Producto;
    }

    public void setProducto(Productos producto) {
        Producto = producto;
    }

}
