package com.example.BDProveedores.Helpers;

import org.springframework.stereotype.Component;

@Component
public class ProveedorValidacion {

    public boolean validarNitRut(String nitRut)throws Exception{
        if(nitRut.length()==0){
            throw new Exception("El campo no puede estar vacio");

        }
        if(nitRut.length()>50){
            throw new Exception("El NIT o RUT no puede tener mas de 50 caracteres");
        }

        String regex = "^[0-9-]+$";

        if(!ValidarRegex.evaluarPatron(regex, nitRut)){

            throw new Exception("Solo se pueden ingresar numeros");
        }
return true;

    }

    public boolean validarRazonSocial(String razonSocial)throws Exception{
        if(razonSocial.length()==0){
            throw new Exception("El campo no puede estar vacio");

        }
        if(razonSocial.length()>50){
            throw new Exception("El nombre no puede tener mas de 50 caracteres");
        }

        String regex = "^[a-zA-Z]+$";

        if(!ValidarRegex.evaluarPatron(regex, razonSocial)){

            throw new Exception("Solo se pueden ingresar letras");
        }
        return true;

    }

    public boolean validarRepresentante(String representante)throws Exception{
        if(representante.length()==0){
            throw new Exception("El campo no puede estar vacio");

        }
        if(representante.length()>50){
            throw new Exception("El nombre no puede tener mas de 50 caracteres");
        }

        String regex = "^[a-zA-Z\\s]+$";

        if(!ValidarRegex.evaluarPatron(regex, representante)){

            throw new Exception("Solo se pueden ingresar letras");
        }
        return true;

    }

    public boolean validarDireccion(String direccion)throws Exception{
        if(direccion.length()==0){
            throw new Exception("El campo no puede estar vacio");

        }
        if(direccion.length()>50){
            throw new Exception("La direccion no puede tener mas de 50 caracteres");
        }

        String regex = "^[a-zA-Z0-9#\\- ]+$";

        if(!ValidarRegex.evaluarPatron(regex, direccion)){

            throw new Exception("La direccion no es valida");
        }
        return true;

    }
    public boolean validarTelefono(String telefono)throws Exception{
        if(telefono.length()==0){
            throw new Exception("El campo no puede estar vacio");

        }
        if(telefono.length()>10){
            throw new Exception("El telefono no puede tener mas de 10 caracteres");
        }

        String regex = "^[0-9]{10}$";

        if(!ValidarRegex.evaluarPatron(regex, telefono)){

            throw new Exception("Solo se pueden ingresar numeros");
        }
        return true;

    }

    public boolean validarCorreo(String correo)throws Exception{
        if(correo.length()==0){
            throw new Exception("El campo no puede estar vacio");

        }
        if(correo.length()>50){
            throw new Exception("El correo no puede tener mas de 50 caracteres");
        }

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if(!ValidarRegex.evaluarPatron(regex, correo)){

            throw new Exception("Correo no es valido");
        }
        return true;

    }


}
