/**
 * 
 */
package com.soa.business;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 *  Capa de negocio de concatenación de Strings.
 */
@Component
public class NombreBusiness {

//    public String nombre(String s1) {
//        return String.format(s1);
//    }
//    public String apellidoPaterno(String s1) {
//        return String.format(s1);
//    }
//    public String apellidoMaterno(String s1) {
//        return String.format(s1);
//    }
    
    public List<String> obtenerElementos(String cadena) {
        String[] arregloElementos = cadena.split(", "); // Divide la cadena en elementos usando comas como separador
        return Arrays.asList(arregloElementos); // Convierte el arreglo en una lista
    }
    
}
