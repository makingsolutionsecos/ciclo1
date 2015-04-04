
package dto;

/**
 * Clase DTO que contiene la estructura de un archivo metodo
 * contiene toda la información de un metodo de una clase.
 * @author sergio Forero
 * @version 1.0
 * Fecha 01/04/2015
 */
public class Metodo {
    
    /**
     * nombre del metodo
     */
    private String nombre;
    
    /**
     * cantidad de lineas que el metodo
     */
    private int cantidadLineasMetodo;
    
    /**
     * cantidad de veces que el metodo se llama dentro del proyecto
     */
    private int cantidadNumeroLLamados;
    
    /**
     * cantidad de puntos de desicion que tiene el metodo
     */
    private int cantidadPuntosDecision;

    /**
     * constructor de la clase metodo
     */
    public Metodo() {
    }    
    
    
    /**
     * obtiene el nombre del metodo
     * @return String nombre del metodo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo encargado de establecer el valor del nombre del metodo
     * @param nombre nombre del metodo a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * obtiene la cantidad de lineas de codigo del metodo
     * @return int cantidad de lineas del metodo
     */
    public int getCantidadLineasMetodo() {
        return cantidadLineasMetodo;
    }

    /**
     * metodo encargado de establecer la cantidad de lineas que tiene el metodo
     * @param cantidadLineasMetodo valor a establecer de lineas del metodo
     */
    public void setCantidadLineasMetodo(int cantidadLineasMetodo) {
        this.cantidadLineasMetodo = cantidadLineasMetodo;
    }

    /**
     * obtiene la cantidad de llamados que tiene el metodo
     * @return int numero de llamados del metodo
     */
    public int getCantidadNumeroLLamados() {
        return cantidadNumeroLLamados;
    }

    /**
     * metodo encargado de establecer el numero de llamados del metodo
     * @param cantidadNumeroLLamados valor del numero de llamados del metodo a establecer
     */
    public void setCantidadNumeroLLamados(int cantidadNumeroLLamados) {
        this.cantidadNumeroLLamados = cantidadNumeroLLamados;
    }

    /**
     * obtiene la cantidad de puntos de decision del metodo
     * @return int numero de puntos de decision del metodo
     */
    public int getCantidadPuntosDecision() {
        return cantidadPuntosDecision;
    }

    /**
     * metodo encargado de establecer el valor de la cantidad de puntos de decision del metodo
     * @param cantidadPuntosDecision  valor a establecer del numero de puntos de deciison
     */
    public void setCantidadPuntosDecision(int cantidadPuntosDecision) {
        this.cantidadPuntosDecision = cantidadPuntosDecision;
    }
}
