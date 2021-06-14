package com.proyecto.demo.controller;

import com.proyecto.demo.Entity.tb_cliente;
import com.proyecto.demo.service.clienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/clientes")
public class principalController {


    private static final Logger log = LoggerFactory.getLogger(principalController.class);


    @Autowired
    private clienteService clientService;

    @GetMapping
    public ResponseEntity<List<tb_cliente>> listar(){
        List<tb_cliente> clientes = new ArrayList<>();
        clientes = clientService.getTotal();
        return new ResponseEntity<List<tb_cliente>>(clientes, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public tb_cliente listaporIdClientes(@PathVariable Integer id) {
        return clientService.getTotalid(id);
    }


    @DeleteMapping("/{id}")
    public String EliminarClientes(@PathVariable Integer id) {
        tb_cliente med = clientService.getTotalid(id);
        if (med == null) {
            return "No existe el registro";
        } else {
            clientService.deleteClientes(id);
        return "Se elimino correctamente";
        }



    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String registrar(@RequestBody tb_cliente cliente) {

        boolean resul = clientService.getregistrarClientes(cliente.getNombre(), cliente.getApellido(), cliente.getCorreo());

       log.info("Hola mundo    " + resul);
        if (resul == true){
            return "Se insertaron correctamente los datos de la tabla cliente";
    }else {
            return "Los datos de la tabla cliente no fueron insertados ";
        }
       // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getId_tb_cliente()).toUri();


    }


    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String actualizar(
         //   @PathVariable Integer id
           @RequestBody tb_cliente cliente
    ) {

     //  tb_cliente re= clientService.getTotalid(id);
   Boolean resul = clientService.getActualizarClientes(cliente.getId_tb_cliente(),cliente.getNombre(), cliente.getApellido(), cliente.getCorreo());


        if (resul == true){
            return "Se actualizaron correctamente los datos de la tabla cliente";
        }else {
            return "Los datos de la tabla cliente no fueron actualizados ";
        }
        // URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getId_tb_cliente()).toUri();


    }


}
