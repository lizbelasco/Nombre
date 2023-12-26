/**
 * 
 */
package com.soa.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.google.gson.Gson;
import com.soa.VelascoRicardezResponse;
import com.soa.LizbethRequest;
import com.soa.business.NombreBusiness;

/**
 * Clase que publica un servicio web tipo SOAP. Capa Boundary
 */
@Endpoint
public class NombreEndpoint {
    /** Objeto inyectado de la capa de negocio. */
    @Autowired
    private NombreBusiness business;

    /** Targetnamespace. */
    private static final String NAMESPACE_URI = "http://soa.com";

    /**
     * Operación SOAP expuesta en http.
     * @param request Objeto con datos de entrada. (Capa de Modelo).
     * @return objeto con datos de salida (Capa de modelo)
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "LizbethRequest")
    @ResponsePayload
    public VelascoRicardezResponse nombreOperation(
            @RequestPayload LizbethRequest request) {
        VelascoRicardezResponse out = new VelascoRicardezResponse();
//        VELASCO, RICARDEZ, LIZBETH MARIA
//        String nombre = business.nombre(request.getNombreCompleto().substring(0,8));
//        String apellidoPaterno = business.nombre(request.getNombreCompleto().substring(9,18));
//        String apellidoMaterno = business.nombre(request.getNombreCompleto().substring(19,32));
//        out.setNombre(nombre);
//        out.setApellidoPaterno(apellidoPaterno);
//        out.setApellidoMaterno(apellidoMaterno);
        
        String listaCadena = request.getNombreCompleto();
        
        List<String> cadenaGenerada = business.obtenerElementos(listaCadena);

        out.setApellidoPaterno(cadenaGenerada.get(0));
        out.setApellidoMaterno(cadenaGenerada.get(1));
        out.setNombre(cadenaGenerada.get(2));
        
        return out;
    }
}