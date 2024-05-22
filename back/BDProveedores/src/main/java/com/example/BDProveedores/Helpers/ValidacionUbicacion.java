package com.example.BDProveedores.Helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionUbicacion {

    public boolean validarPais(String pais)throws Exception{
        if (pais.length()==0){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (pais.length()>50){
            throw new Exception("El nombre no puede tener mas de 50 caracteres");
        }
        String regex="^[a-zA-Z ]+$";

        if (!ValidarRegex.evaluarPatron(regex,pais)){
            throw new Exception("revisa el nombre ingresado ya que solo puede tener letras");
        }
        return true;
    }
    public boolean validarCiudad(String ciudad)throws Exception{
        if (ciudad.length()==0){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (ciudad.length()>50){
            throw new Exception("El nombre no puede tener mas de 50 caracteres");
        }
        String regex="^[a-zA-Z ]+$";
        // evaluo si el nombre coincide con la expresion
        if (!ValidarRegex.evaluarPatron(regex,ciudad)){
            throw new Exception("revisa el nombre ingresado ya que solo puede tener letras");
        }
        return true;
    }

    public boolean validarDepartamento(String departamento)throws Exception{
        if (departamento.length()==0){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (departamento.length()>50){
            throw new Exception("El nombre no puede tener mas de 50 caracteres");
        }
        String regex="^[a-zA-Z ]+$";

        if (!ValidarRegex.evaluarPatron(regex, departamento)){
            throw new Exception("revisa el nombre ingresado ya que solo puede tener letras");
        }
        return true;
    }

}
