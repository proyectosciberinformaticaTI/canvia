package com.proyecto.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class tb_categoria {


    @Id
    private int id_tb_categoria;


    private String descripcion;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tb_producto", nullable = false)
    private tb_producto producto;

}
