package com.proyecto.demo.controller;


import com.proyecto.demo.Entity.tb_cliente;
import com.proyecto.demo.Entity.tb_producto;
import com.proyecto.demo.service.clienteService;
import com.proyecto.demo.service.productoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/productos")
public class productoController {





    private productoService productService;




    @GetMapping
    public ResponseEntity<List<tb_producto>> listar(){
        List<tb_producto> productos = new ArrayList<>();
        productos = productService.getTotal();
        return new ResponseEntity<List<tb_producto>>(productos, HttpStatus.OK);
    }



}
