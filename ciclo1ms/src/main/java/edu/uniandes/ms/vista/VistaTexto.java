package edu.uniandes.ms.vista;

import edu.uniandes.ms.controlador.Controlador;
import edu.uniandes.ms.dto.Clase;
import edu.uniandes.ms.dto.Metodo;
import edu.uniandes.ms.dto.RespuestaAnalisis;
import edu.uniandes.ms.dto.RespuestaConteo;
import edu.uniandes.ms.modelo.LenguajeEnum;
import java.io.File;
import java.util.List;

/**
 * Clase que contiente las implementaciones de un grupo de funciones
 * relacionadas con la solicitud y generación del análisis de código definidas
 * en la interfaz IVista.
 *
 * @author John Dany osorio Ramos
 * @version 1.0
 * Fecha: 04/04/2015
 */
public class VistaTexto implements IVista {

    /**
     * Método que analiza el código fuente de un lenguaje en específico y se
     * obtiene su respectivo análisis.
     *
     */
    @Override
    public void analizarDirectorioFuente() {

        // Para el ciclo 1 el lenguaje y la ruta del código fuente se van a dejar quemados.
        LenguajeEnum lenguaje = LenguajeEnum.JAVA;
        File directorio = new File(System.getProperty("user.dir") + File.separator + 
                "target" + File.separator + "classes" +
                File.separator + "src");

        Controlador controlador = new Controlador();
        pintar(controlador.analizarDirectorioFuente(directorio.getPath(), lenguaje));
    }

    /**
     * Método encargado de pintar la respuesta del análisis del código fuente
     * analizado.
     *
     * @param respuestaAnalisis Respuesta que contiene el análisis detallado del
     * código fuente analizado.
     */
    @Override
    public void pintar(RespuestaAnalisis respuestaAnalisis) {

        System.out.println("Proyecto: Ciclo #1 TSP");
        RespuestaConteo respuestaConteo = respuestaAnalisis.getRespuestaConteo();
        List<Clase> clases = respuestaConteo.getListaClases();
        System.out.println("Número de clases: " + respuestaConteo.getNumeroClases());
        System.out.println("Resumen de Clases ");

        for (Clase clase : clases) {
            System.out.println("\tNombre de la clase: " + clase.getNombre());
            System.out.println("\tCantidad líneas de la clase: " + clase.getCantidadLineasClase());
            System.out.println("");
            List<Metodo> metodos = clase.getListaMetodos();
            System.out.println("\t\tResumen de métodos: ");

            for (Metodo metodo : metodos) {
                System.out.println("\t\tNombre del método: " + metodo.getNombre());
                System.out.println("\t\tCantidad líneas del método: " + metodo.getCantidadLineasMetodo());
            }
            System.out.println("");
        }
    }
}
