package com.example.BDProveedores.Servicios;

import com.example.BDProveedores.Modelos.Archivo;
import com.example.BDProveedores.Repositorios.ArchivoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchivoServicio {

    @Autowired
    private ArchivoRepositorio archivoRepositorio;

    public Archivo guardarArchivo(Archivo archivo) {
        return archivoRepositorio.save(archivo);
    }
}
