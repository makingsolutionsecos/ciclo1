package edu.uniandes.ms.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase DTO que contiene la estructura de un archivo clase y contendra el
 * nombre, cantidad de lineas e información de los metodos de la clase
 *
 * @author sergio Forero
 * @version 1.0 Fecha 03/04/2015
 */
public class Clase {

    /**
     * contendra una lista de metodos que se encuentran en una clase
     */
    private List<Metodo> listaMetodos;

    /**
     * nombre de la calse
     */
    private String nombre;

    /**
     * cantidad de lineas que tiene la clase
     */
    private int cantidadLineasClase;

    /**
     * numero de veces que la clase es llamada dentro del proyecto
     */
    private int llamados;

    /**
     * complejidad ciclomática del metodo
     */
    private int complejidadMcCabe;

    /**
     * constructor de la clase Inicializa la lista de metodos
     */
    public Clase() {
        this.listaMetodos = new ArrayList<Metodo>();
    }

    /**
     * metodo que agrega metodos a la lista de metodos de la clase
     *
     * @param metodo metodo para agregar a la lista de metodos
     */
    public void addMetodo(Metodo metodo) {
        this.listaMetodos.add(metodo);
    }

    /**
     * obtiene la lista de metodos
     *
     * @return List<Metodo> lista de metodos de la clase
     */
    public List<Metodo> getListaMetodos() {
        return listaMetodos;
    }

    /**
     * metodo encargado de establecer la variable de lista de metodos
     *
     * @param listaMetodos valor para establecer la variable lista de metodos
     */
    public void setListaMetodos(List<Metodo> listaMetodos) {
        this.listaMetodos = listaMetodos;
    }

    /**
     * obtiene el nombre de la case
     *
     * @return String nombre de la clase
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo encargado de establecer el nombre de la case
     *
     * @param nombre nombre de la clase a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * obtiene el numero de lineas de la clase
     *
     * @return int numero lineas de la clase
     */
    public int getCantidadLineasClase() {
        return cantidadLineasClase;
    }

    /**
     * metodo encargado de establecer el numero de lineas de la clase
     *
     * @param cantidadLineasClase numero de lineas a establecer
     */
    public void setCantidadLineasClase(int cantidadLineasClase) {
        this.cantidadLineasClase = cantidadLineasClase;
    }

    /**
     * obtiene el numero de veces que la clase es llamada en el proyecto
     *
     * @return int numero de llamados de esta clase
     */
    public int getLlamados() {
        return llamados;
    }

    /**
     * metodo encargado de establecer el numero de llamados de la clase
     *
     * @param llamados numero de llamados de la clase
     */
    public void setLlamados(int llamados) {
        this.llamados = llamados;
    }

    /**
     * obtiene la complejidad de McCabe que es una metrica que proporciona una
     * medicion de complejidad logica de la clase.
     *
     * @return int complejidad de McCabe de la clase.
     */
    public int getComplejidadMcCabe() {
        return this.complejidadMcCabe;
    }

    /**
     * metodo encargado de asignar la complejidad de McCabe obtenida.
     *
     * @param complejidadMcCabe valor a establecer.
     */
    public void setComplejidadMcCabe(int complejidadMcCabe) {
        this.complejidadMcCabe = complejidadMcCabe;
    }
}
