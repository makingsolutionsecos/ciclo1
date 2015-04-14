
package edu.uniandes.ms.dto;

/**
 * Clase DTO que contiene la estructura de un archivo metodo
 * contiene toda la informaci�n de el m�todo de una clase.
 * @author sergio Forero
 * @version 1.0
 * Fecha 04/04/2015
 */
public class Metodo {
    
    /**
     * nombre del m�todo
     */
    private String nombre;
    
    /**
     * cantidad de l�neas que el m�todo
     */
    private int cantidadLineasMetodo;
    
    /**
     * cantidad de veces que el m�todo se llama dentro del proyecto
     */
    private int cantidadNumeroLLamados;
    
    /**
     * cantidad de puntos de desici�n que tiene el metodo
     */
    private int cantidadPuntosDecision;

    /**
     * constructor de la clase m�todo
     */
    public Metodo() {
    }    
    
    
    /**
     * obtiene el nombre del m�todo
     * @return String nombre del metodo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo encargado de establecer el valor del nombre del m�todo
     * @param nombre nombre del m�todo a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * obtiene la cantidad de l�neas de c�digo del m�todo
     * @return int cantidad de l�neas del m�todo
     */
    public int getCantidadLineasMetodo() {
        return cantidadLineasMetodo;
    }

    /**
     * m�todo encargado de establecer la cantidad de l�neas que tiene el m�todo
     * @param cantidadLineasMetodo valor a establecer de l�neas del m�todo
     */
    public void setCantidadLineasMetodo(int cantidadLineasMetodo) {
        this.cantidadLineasMetodo = cantidadLineasMetodo;
    }

    /**
     * obtiene la cantidad de llamados que tiene el m�todo
     * @return int n�mero de llamados del m�todo
     */
    public int getCantidadNumeroLLamados() {
        return cantidadNumeroLLamados;
    }

    /**
     * m�todo encargado de establecer el numero de llamados del m�todo
     * @param cantidadNumeroLLamados valor del n�mero de llamados del m�todo a establecer
     */
    public void setCantidadNumeroLLamados(int cantidadNumeroLLamados) {
        this.cantidadNumeroLLamados = cantidadNumeroLLamados;
    }

    /**
     * obtiene la cantidad de puntos de decisi�n del m�todo
     * @return int n�mero de puntos de decisi�n del m�todo
     */
    public int getCantidadPuntosDecision() {
        return cantidadPuntosDecision;
    }

    /**
     * m�todo encargado de establecer el valor de la cantidad de puntos de decisi�n del m�todo
     * @param cantidadPuntosDecision  valor a establecer del n�mero de puntos de decisi�n
     */
    public void setCantidadPuntosDecision(int cantidadPuntosDecision) {
        this.cantidadPuntosDecision = cantidadPuntosDecision;
    }
}
