package com.proyecto.demo.service;




import com.proyecto.demo.Entity.tb_producto;
import com.proyecto.demo.repository.Productorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class productoService {

    @Autowired
    private Productorepository productoRepository;


    public List<tb_producto> getTotal() {
        return productoRepository.getTotales();
    }


}
