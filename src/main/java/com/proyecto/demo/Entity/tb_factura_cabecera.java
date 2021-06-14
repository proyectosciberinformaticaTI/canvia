package com.proyecto.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;



public class tb_factura_cabecera {

    private int id_tb_factura_cabecera;

    private String numeroorden;

    private int totalcantidad;

    private double preciototal;

    private String status;

    private Date fechacreacion;

    private Date fechaactualizacion;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<tb_item_detalle> detalle;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private tb_cliente cliente;
}
