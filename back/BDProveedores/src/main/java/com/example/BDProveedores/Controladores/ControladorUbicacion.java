package com.example.BDProveedores.Controladores;

import com.example.BDProveedores.Modelos.Ubicacion;
import com.example.BDProveedores.Servicios.UbicacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ubicacion")
public class ControladorUbicacion {

    @Autowired
    UbicacionServicio ubicacionServicio;

    @PostMapping

    public ResponseEntity<?> guardarUbicacion(@RequestBody Ubicacion datosUbicacion){

        try{

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ubicacionServicio.guardarUbicacion(datosUbicacion));



        }catch (Exception error){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }

    }

}
