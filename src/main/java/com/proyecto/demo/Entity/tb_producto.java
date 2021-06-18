package com.proyecto.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class tb_producto {


    @Id
    private int id_tb_producto;

    private String descripcion;

    private double precio;

    private int stock;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    private List<tb_categoria> categorias;

}
