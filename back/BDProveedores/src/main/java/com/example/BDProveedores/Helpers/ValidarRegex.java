package com.example.BDProveedores.Helpers;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidarRegex {

    public static boolean evaluarPatron(String regex, String evaluarRegex){

        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(evaluarRegex);
        return  matcher.matches() ? true : false;

    }

}
