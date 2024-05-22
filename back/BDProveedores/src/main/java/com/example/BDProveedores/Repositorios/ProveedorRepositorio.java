package com.example.BDProveedores.Repositorios;

import com.example.BDProveedores.Modelos.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedores, Integer> {

}
