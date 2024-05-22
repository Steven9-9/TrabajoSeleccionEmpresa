package com.example.BDProveedores.Repositorios;

import com.example.BDProveedores.Modelos.Archivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivoRepositorio extends JpaRepository<Archivo, Integer> {
}
