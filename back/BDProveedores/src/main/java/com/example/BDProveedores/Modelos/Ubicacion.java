package com.example.BDProveedores.Modelos;

import jakarta.persistence.*;

@Entity
@Table(name="ubicacion")
public class Ubicacion {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_ubicacion;
        @Column(name = "ciudad", nullable = false, length = 50)
        private String ciudad;
        @Column(name = "pais", nullable = false, length = 50)
       private String pais;
       @Column(name = "departamento", nullable = false, length = 50)
       private String departamento;

    public Ubicacion(Integer id, String ciudad, String pais, String departamento) {
        this.id_ubicacion = id;
        this.ciudad = ciudad;
        this.pais = pais;
        this.departamento = departamento;
    }

    public Integer getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(Integer id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}

