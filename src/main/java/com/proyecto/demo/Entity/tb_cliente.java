package com.proyecto.demo.Entity;


import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "Cliente id")
    private int id_tb_cliente;

    @ApiModelProperty(notes = "Nombre del cliente")
    private  String nombre;

    @ApiModelProperty(notes = "Apellido del cliente")
    private String apellido;


    @ApiModelProperty(notes = "Correo del cliente")
    private String correo;




}
