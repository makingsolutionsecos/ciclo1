package edu.uniandes.ms.vista;

import edu.uniandes.ms.controlador.Controlador;
import edu.uniandes.ms.dto.Clase;
import edu.uniandes.ms.dto.Metodo;
import edu.uniandes.ms.dto.RespuestaAnalisis;
import edu.uniandes.ms.dto.RespuestaConteo;
import edu.uniandes.ms.modelo.LenguajeEnum;
import java.util.List;

/**
 * Clase que contiente las implementaciones de un grupo de funciones
 * relacionadas con la solicitud y generaci�n del an�lisis de c�digo definidas
 * en la interfaz IVista.
 *
 * @author John Dany osorio Ramos
 * @version 1.0
 * Fecha: 04/04/2015
 */
public class VistaTexto implements IVista {

    /**
     * M�todo que analiza el c�digo fuente de un lenguaje en espec�fico y se
     * optiene su respectivo an�lisis.
     *
     */
    @Override
    public void analizarDirectorioFuente() {

        // Para el ciclo 1 el lenguaje y la ruta del c�digo fuente se van a dejar quemados.
        LenguajeEnum lenguaje = LenguajeEnum.JAVA;
        String ruta = "/Users/camilomarroquin/NetBeansProjects/TSP.Model";

        Controlador controlador = new Controlador();
        pintar(controlador.analizarDirectorioFuente(ruta, lenguaje));
    }

    /**
     * M�todo encargado de pintar la respuesta del an�lisis del c�digo fuente
     * analizado.
     *
     * @param respuestaAnalisis Respuesta que contiene el an�lisis detallado del
     * c�digo fuente analizado.
     */
    @Override
    public void pintar(RespuestaAnalisis respuestaAnalisis) {

        System.out.println("Proyecto: TSP.Model");
        RespuestaConteo respuestaConteo = respuestaAnalisis.getRespuestaConteo();
        List<Clase> clases = respuestaConteo.getListaClases();
        System.out.println("N�mero de clases: " + respuestaConteo.getNumeroClases());
        System.out.println("Resumen de Clases ");

        for (Clase clase : clases) {
            System.out.println("\tNombre de la clase: " + clase.getNombre());
            System.out.println("\tCantidad lineas de la clase: " + clase.getCantidadLineasClase());
            System.out.println("");
            List<Metodo> metodos = clase.getListaMetodos();
            System.out.println("\t\tResumen de m�todos: ");

            for (Metodo metodo : metodos) {
                System.out.println("\t\tNombre del metodo: " + metodo.getNombre());
                System.out.println("\t\tCantidad lineas del m�todo: " + metodo.getCantidadLineasMetodo());
            }
            System.out.println("");
        }
    }
}
