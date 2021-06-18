package com.proyecto.demo.repository;


import com.proyecto.demo.Entity.tb_cliente;
import com.proyecto.demo.Entity.tb_producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface Productorepository extends JpaRepository<tb_producto,Integer> {




    @Query(value = "CALL PRODUCTO_LISTADO();", nativeQuery = true)
    List<tb_producto> getTotales();

}
