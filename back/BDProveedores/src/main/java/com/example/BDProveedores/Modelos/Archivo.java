package com.example.BDProveedores.Modelos;


import jakarta.persistence.*;

@Entity
@Table(name="urlPdf")
public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_archivo;

    @Column (name = "url", nullable = false, length = 100)
    private String url;

    public Archivo(Integer id, String url) {
        this.id_archivo = id;
        this.url = url;
    }

    public Archivo() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
