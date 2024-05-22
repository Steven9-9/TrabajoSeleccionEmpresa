package com.example.BDProveedores.Repositorios;

import com.example.BDProveedores.Modelos.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UbicacionRepositorio extends JpaRepository<Ubicacion, Integer> {
}
