package com.proyecto.demo.repository;


import com.proyecto.demo.Entity.tb_cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Clienterepository extends JpaRepository<tb_cliente,Integer> {




    @Procedure(name = "tb_cliente.LISTADO_CLIENTE_POR_ID")
    String getTotalClientes(@Param("c_id") Integer id,@Param("c_nombre") String nombre,
                                 @Param("c_apellido") String apellido,@Param("c_correo") String correo);


    @Query(value = "CALL LISTADO_CLIENTE_POR_ID(:c_id);", nativeQuery = true)
    tb_cliente findIdClientes(@Param("c_id") Integer id);



    @Query(value = "CALL DELETE_CLIENTES(:c_id);", nativeQuery = true)
    tb_cliente deleteClientes(@Param("c_id") Integer id);

  //  @Procedure(name = "tb_cliente.LISTADO_TOTAL")
   // List<tb_cliente>  getTotalDEClientes();

   @Query(value = "CALL LISTADO_TOTAL();", nativeQuery = true)
 List<tb_cliente> getTotales();

 //  @Procedure(name = "tb_cliente.PROC_REGISTRO_CLIENTE")
  // Integer getregistrardetotalClientes(@Param("c_nombres") String nombre,
   //                            @Param("c_apellidos") String apellido,@Param("c_correos") String correo);


    @Query(value = "CALL PROC_REGISTRO_CLIENTE(:c_nombres,:c_apellidos,:c_correos);", nativeQuery = true)
   Integer getregistrarClientes(@Param("c_nombres") String nombre,
                                  @Param("c_apellidos") String apellido,@Param("c_correos") String correo);


    @Query(value = "CALL UPDATE_CLIENTES(:c_id,:c_nombre,:c_apellido,:c_correo);", nativeQuery = true)
    Integer getactualizarClientes(@Param("c_id") Integer id,@Param("c_nombre") String nombre,
                                 @Param("c_apellido") String apellido,@Param("c_correo") String correo);
}
