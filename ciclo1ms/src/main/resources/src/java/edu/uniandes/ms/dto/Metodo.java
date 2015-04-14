
package edu.uniandes.ms.dto;

/**
 * Clase DTO que contiene la estructura de un archivo metodo
 * contiene toda la información de el método de una clase.
 * @author sergio Forero
 * @version 1.0
 * Fecha 04/04/2015
 */
public class Metodo {
    
    /**
     * nombre del método
     */
    private String nombre;
    
    /**
     * cantidad de líneas que el método
     */
    private int cantidadLineasMetodo;
    
    /**
     * cantidad de veces que el método se llama dentro del proyecto
     */
    private int cantidadNumeroLLamados;
    
    /**
     * cantidad de puntos de desición que tiene el metodo
     */
    private int cantidadPuntosDecision;

    /**
     * constructor de la clase método
     */
    public Metodo() {
    }    
    
    
    /**
     * obtiene el nombre del método
     * @return String nombre del metodo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo encargado de establecer el valor del nombre del método
     * @param nombre nombre del método a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * obtiene la cantidad de líneas de código del método
     * @return int cantidad de líneas del método
     */
    public int getCantidadLineasMetodo() {
        return cantidadLineasMetodo;
    }

    /**
     * método encargado de establecer la cantidad de líneas que tiene el método
     * @param cantidadLineasMetodo valor a establecer de líneas del método
     */
    public void setCantidadLineasMetodo(int cantidadLineasMetodo) {
        this.cantidadLineasMetodo = cantidadLineasMetodo;
    }

    /**
     * obtiene la cantidad de llamados que tiene el método
     * @return int número de llamados del método
     */
    public int getCantidadNumeroLLamados() {
        return cantidadNumeroLLamados;
    }

    /**
     * método encargado de establecer el numero de llamados del método
     * @param cantidadNumeroLLamados valor del número de llamados del método a establecer
     */
    public void setCantidadNumeroLLamados(int cantidadNumeroLLamados) {
        this.cantidadNumeroLLamados = cantidadNumeroLLamados;
    }

    /**
     * obtiene la cantidad de puntos de decisión del método
     * @return int número de puntos de decisión del método
     */
    public int getCantidadPuntosDecision() {
        return cantidadPuntosDecision;
    }

    /**
     * método encargado de establecer el valor de la cantidad de puntos de decisión del método
     * @param cantidadPuntosDecision  valor a establecer del número de puntos de decisión
     */
    public void setCantidadPuntosDecision(int cantidadPuntosDecision) {
        this.cantidadPuntosDecision = cantidadPuntosDecision;
    }
}
