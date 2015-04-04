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
        this.listaClases = new ArrayList<dto.Clase>();
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
    public void setListaClases(List<dto.Clase> listaClases) {
        this.listaClases = listaClases;
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

