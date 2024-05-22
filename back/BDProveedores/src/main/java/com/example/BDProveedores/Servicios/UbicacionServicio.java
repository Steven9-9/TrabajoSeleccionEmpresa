package com.example.BDProveedores.Servicios;

import com.example.BDProveedores.Helpers.ValidacionUbicacion;
import com.example.BDProveedores.Modelos.Ubicacion;
import com.example.BDProveedores.Repositorios.UbicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbicacionServicio {

    @Autowired
    ValidacionUbicacion validacionUbicacion;

    @Autowired
    UbicacionRepositorio ubicacionRepositorio;

public Ubicacion guardarUbicacion(Ubicacion datosUbicacion) throws Exception{

    if(!validacionUbicacion.validarCiudad(datosUbicacion.getCiudad())){
        throw new IllegalArgumentException("Ciudad no valida");
    }

    if(!validacionUbicacion.validarPais(datosUbicacion.getPais())){

        throw new IllegalArgumentException("Pais no valido");
    }
    if(!validacionUbicacion.validarDepartamento(datosUbicacion.getDepartamento())){
        throw new IllegalArgumentException("Departamento no valido");
    }
    try {
        return ubicacionRepositorio.save(datosUbicacion);
    } catch (Exception e) {
        throw new Exception("Error al guardar usuario: " + e.getMessage());
    }
}


}
