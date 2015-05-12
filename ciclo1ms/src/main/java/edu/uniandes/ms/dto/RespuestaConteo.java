package edu.uniandes.ms.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clase DTO que contiene la estructura de la respuesta de conteo
 * @author Camilo Marroquin
 * @version 1.0
 * Fecha 02/04/2015
 */
public class RespuestaConteo {
    
    /**
     * Lista de clases encontradas
     */
    private List<Clase> listaClases;
    
    /**
     * Lista de Metodos en todo el proyecto
     */
    HashMap<String, Integer> llamadoMetodos;

    /**
     * Constructor de la clase
     * Inicializa la lista de clases
     */
    public RespuestaConteo() {
        this.listaClases = new ArrayList<Clase>();
    }
    
    /**
     * Obtetine la lista de clases del proyecto
     * @return List<Clase> Lista de clases del proyecto
     */
    public List<Clase> getListaClases() {
        return listaClases;
    }

    /**
     * Establece la lista de clases del proyecto
     * @param listaClases Lista de clases a agregar 
     */
    public void setListaClases(List<Clase> listaClases) {
        this.listaClases = listaClases;
    }
    
    public int getCantidadLineasTotal(){
        int cantidadLineasTotal = 0;
        for (Clase clase : this.listaClases) { 
            cantidadLineasTotal += clase.getCantidadLineasClase();
        }
        return cantidadLineasTotal;
    }
    
    public String getComplejidadMcCabeTotal(){
        int complejidadMcCabeTotal = 0;
        String respuestaComplejidad = "";
        for (Clase clase : this.listaClases) { 
            List<Metodo> metodos = clase.getListaMetodos();
            for (Metodo metodo : metodos) {
                complejidadMcCabeTotal += metodo.getComplejidadMcCabe();
            }
        }
        respuestaComplejidad += complejidadMcCabeTotal;
        if(complejidadMcCabeTotal < 10)
            respuestaComplejidad += " Programa simple, sin mucho riesgo.";
        else if(complejidadMcCabeTotal > 10 && complejidadMcCabeTotal < 20)
            respuestaComplejidad += " Programa mediamente complejo, riesgo moderado.";
        else if(complejidadMcCabeTotal > 20 && complejidadMcCabeTotal < 50)
            respuestaComplejidad += " Programa complejo, alto riesgo.";
        else
            respuestaComplejidad += " Programa no testeable, riesgo muy alto.";
        
        return respuestaComplejidad;
    }
     
    /**
     * Obtiene la lista de llamdos de los metodos
     * @return HashMap<String, Integer> Lista de llamados a los metodos
     */
    public HashMap<String, Integer> getLlamadoMetodos() {
        return llamadoMetodos;
    }

    /**
     * Establece la lista de llamados de metodos
     * @param llamadoMetodos 
     */
    public void setLlamadoMetodos(HashMap<String, Integer> llamadoMetodos) {
        this.llamadoMetodos = llamadoMetodos;
    }

    /**
     * Obtiene el numero de clases del proyecto
     * @return 
     */
    public int getNumeroClases(){
        return this.listaClases.size();
    }
}

