package com.proyecto.demo.service;


import com.proyecto.demo.Entity.tb_cliente;
import com.proyecto.demo.repository.Clienterepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class clienteService{
    @Autowired
    private Clienterepository clienteRepository;

    @PersistenceContext
    private EntityManager manager;

    public tb_cliente getTotalid(Integer id) {
        return clienteRepository.findIdClientes(id);
    }

    public boolean deleteClientes(Integer id) {
        try
        {
            StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("DELETE_CLIENTES")
                    .registerStoredProcedureParameter(0 , Integer.class , ParameterMode.IN);

            storedProcedure .setParameter(0,id);

            storedProcedure.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<tb_cliente> getTotal() {
        return clienteRepository.getTotales();
    }

    public boolean getregistrarClientes(String nombre, String apellido, String correo){
        try
        {
            StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("PROC_REGISTRO_CLIENTE")
                    .registerStoredProcedureParameter(0 , String.class , ParameterMode.IN)
                    .registerStoredProcedureParameter(1 , String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(2 , String.class, ParameterMode.IN);

            storedProcedure .setParameter(0, nombre)
                    .setParameter(1, apellido)
                    .setParameter(2, correo);

            storedProcedure.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean getActualizarClientes(Integer id, String nombre, String apellido, String correo){

        try
        {
            StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("UPDATE_CLIENTES")
                    .registerStoredProcedureParameter(0 , Integer.class , ParameterMode.IN)
                    .registerStoredProcedureParameter(1 , String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(2 , String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(3 , String.class, ParameterMode.IN)
                    ;

            storedProcedure .setParameter(0, id)
                    .setParameter(1, nombre)
                    .setParameter(2, apellido)
                    .setParameter(3, correo);

            storedProcedure.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
