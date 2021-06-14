package com.proyecto.demo.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "tb_cliente.LISTADO_CLIENTE_POR_ID",
                procedureName = "LISTADO_CLIENTE_POR_ID",
                resultClasses = { tb_cliente.class },
                parameters = {
                        @StoredProcedureParameter(

                                name = "c_id",
                                type = Integer.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "tb_cliente.PROC_REGISTRO_CLIENTE",
                procedureName = "PROC_REGISTRO_CLIENTE",
                resultClasses = { tb_cliente.class },
                parameters = {
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN,
                                name = "c_nombres",
                                type = String.class),
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN,
                                name = "c_apellidos",
                                type = String.class),
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN,
                                name = "c_correos",
                                type = String.class)
                }
        ),@NamedStoredProcedureQuery(
        name = "tb_cliente.LISTADO_TOTAL",
        procedureName = "LISTADO_TOTAL",
        resultClasses = { tb_cliente.class }
)
})
public class tb_cliente {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_tb_cliente;

    private  String nombre;

    private String apellido;

    private String correo;




}
