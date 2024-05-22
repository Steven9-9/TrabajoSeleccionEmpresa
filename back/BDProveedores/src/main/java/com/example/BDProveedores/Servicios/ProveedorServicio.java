package com.example.BDProveedores.Servicios;

import com.example.BDProveedores.Helpers.ProveedorValidacion;
import com.example.BDProveedores.Modelos.Proveedores;
import com.example.BDProveedores.Repositorios.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServicio {

    @Autowired
    ProveedorRepositorio proveedorRepositorio;

    @Autowired
    ProveedorValidacion proveedorValidacion;

    public Proveedores guardarProveedor(Proveedores datosProveedores) throws Exception{

        if(!proveedorValidacion.validarNitRut(datosProveedores.getNitRut())){

            throw new IllegalArgumentException("NIT O RUT invalido");
        }

        if(!proveedorValidacion.validarRazonSocial(datosProveedores.getRazonSocial())){

            throw new IllegalArgumentException("El nombre no es valido");
        }

        if(!proveedorValidacion.validarRepresentante(datosProveedores.getRepresentante())){

            throw new IllegalArgumentException("El nombre no es valido");
        }
        if(!proveedorValidacion.validarDireccion(datosProveedores.getDireccion())){

            throw new IllegalArgumentException("La direccion no es valida");
        }
        if(!proveedorValidacion.validarTelefono(datosProveedores.getTelefono())){

            throw new IllegalArgumentException("El telefono no es valido\"");
        }
        if(!proveedorValidacion.validarCorreo(datosProveedores.getCorreo())){

            throw new IllegalArgumentException("El correo no es valido");
        }
 try{

     return proveedorRepositorio.save(datosProveedores);

 }catch (Exception e){

     throw new Exception("Error al guardar el usuario: " + e.getMessage());

 }


    }







}
