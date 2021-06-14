package com.proyecto.demo.Entity;


import lombok.Data;

import javax.persistence.Entity;


public class tb_item_detalle {


    private int id_tb_item_detalle;
    private double precio;
    private int cantidad;


    private tb_factura_cabecera factura;



}
