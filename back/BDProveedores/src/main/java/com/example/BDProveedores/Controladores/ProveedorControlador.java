package com.example.BDProveedores.Controladores;
import com.example.BDProveedores.Modelos.Proveedores;
import com.example.BDProveedores.Servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorControlador {

    @Autowired
    ProveedorServicio proveedorServicio;


    @PostMapping
  public ResponseEntity <?> guardarProveedor(@RequestBody Proveedores datosProveedores){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(proveedorServicio.guardarProveedor(datosProveedores));


        }catch (Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }

    }

}
