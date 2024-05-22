package com.example.BDProveedores.Modelos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ArchivoRut {

    // Ruta donde se guardarán los archivos
    private static final String UPLOAD_DIRECTORY = "C:/Users/johns/Downloads/BDProveedores/BDProveedoresrc/main/java/com/example/BDProveedores/Archivos";


    public static String guardarArchivo(InputStream archivoInputStream, String nombreArchivo) throws IOException {
        File directorio = new File(UPLOAD_DIRECTORY);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        String rutaArchivo = UPLOAD_DIRECTORY + File.separator + nombreArchivo;


        try (OutputStream outputStream = new FileOutputStream(new File(rutaArchivo))) {
            int lectura;
            byte[] buffer = new byte[1024];
            while ((lectura = archivoInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, lectura);
            }
        }

        return rutaArchivo;
    }


}
