/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.io.Serializable;

public class Almanaque implements Serializable {

    private Integer id_almanaque;

    private Integer id_planta;

    private String fecha_foto;

    private String foto;

    private Productos Producto;

    public Almanaque() {
    }

    public Almanaque(Integer id_planta, Integer id_almanaque, String fecha_foto, String foto) {
        this.id_almanaque = id_almanaque;
        this.fecha_foto = fecha_foto;
        this.foto = foto;
        this.id_planta = id_planta;
    }

    public Integer getId_almanaque() {
        return id_almanaque;
    }

    public void setId_almanaque(Integer id_almanaque) {
        this.id_almanaque = id_almanaque;
    }

    public Integer getId_planta() {
        return id_planta;
    }

    public void setId_planta(Integer id_planta) {
        this.id_planta = id_planta;
    }

    public String getFecha_foto() {
        return fecha_foto;
    }

    public void setFecha_foto(String fecha_foto) {
        this.fecha_foto = fecha_foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Productos getProducto() {
        return Producto;
    }

    public void setProducto(Productos producto) {
        Producto = producto;
    }

}
