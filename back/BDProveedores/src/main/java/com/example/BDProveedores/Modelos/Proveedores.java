package com.example.BDProveedores.Modelos;

import jakarta.persistence.*;
@Entity
@Table(name="proveedores")
public class Proveedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;
    @Column(name = "NIT/RUT", nullable = false, length = 50)
    private String nitRut;
    @Column (name = "razonSocial", nullable = false, length = 50)
    private String razonSocial;
    @Column (name = "representante", nullable = false, length = 50)
    private String representante;
    @Column (name = "direccion",nullable = false, length = 50)
    private String direccion;
    @Column (name = "telefono", nullable = false, length = 50)
    private String telefono;
    @Column (name = "correo", nullable = false, length = 50)
    private String correo;

    public Proveedores(Integer id, String nitRut, String razonSocial, String representante,
                       String direccion, String telefono, String correo ) {

this.id_proveedor = id;
this.nitRut = nitRut;
this.razonSocial = razonSocial;
this.representante = representante;
this.direccion = direccion;
this.telefono = telefono;
this.correo = correo;

    }



    public String getNitRut() {
        return nitRut;
    }

    public void setNitRut(String nitRut) {
        this.nitRut = nitRut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
