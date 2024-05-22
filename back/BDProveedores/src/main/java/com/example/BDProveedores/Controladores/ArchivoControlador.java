package com.example.BDProveedores.Controladores;

import com.example.BDProveedores.Modelos.Archivo;
import com.example.BDProveedores.Servicios.ArchivoServicio;
import com.example.BDProveedores.Modelos.ArchivoRut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/archivos")
public class ArchivoControlador {

    @Autowired
    private ArchivoServicio archivoServicio;

    @PostMapping("/subir")
    public ResponseEntity<?> subirArchivo(MultipartFile archivo) {
        if (archivo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El archivo está vacío.");
        }

        try {
            InputStream archivoInputStream = archivo.getInputStream();
            String nombreArchivo = archivo.getOriginalFilename();
            String rutaArchivo = ArchivoRut.guardarArchivo(archivoInputStream, nombreArchivo);


            Archivo nuevoArchivo = new Archivo();
            nuevoArchivo.setUrl(rutaArchivo);
            archivoServicio.guardarArchivo(nuevoArchivo);

            return ResponseEntity.status(HttpStatus.OK).body("Archivo subido exitosamente. Ruta: " + rutaArchivo);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir el archivo.");
        }
    }

}

