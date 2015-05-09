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
    public String analizarDirectorioFuente(LenguajeEnum lenguaje) {

        // Para el ciclo 1 el lenguaje y la ruta del código fuente se van a dejar quemados.       
        File directorio = new File(System.getProperty("user.dir") + File.separator + 
                "target" + File.separator + "classes" +
                File.separator + "src");

        Controlador controlador = new Controlador();        
        return pintar(controlador.analizarDirectorioFuente(directorio.getPath(), lenguaje));
    }

    /**
     * Método encargado de pintar la respuesta del análisis del código fuente
     * analizado.
     *
     * @param respuestaAnalisis Respuesta que contiene el análisis detallado del
     * código fuente analizado.
     * @return Respuesta
     */
    @Override
    public String pintar(RespuestaAnalisis respuestaAnalisis) {
        String respuesta = "";
        System.out.println("Proyecto: Ciclo #1 TSP");
        respuesta = "<b>Proyecto: Ciclo #1 TSP</b> <br/>";
        RespuestaConteo respuestaConteo = respuestaAnalisis.getRespuestaConteo();
        List<Clase> clases = respuestaConteo.getListaClases();
        System.out.println("Número de clases: " + respuestaConteo.getNumeroClases());
        respuesta +="Número de clases: " + respuestaConteo.getNumeroClases()+"<br/>";
        System.out.println("Número de líneas total: " + respuestaConteo.getCantidadLineasTotal());
        respuesta +="Número de líneas total: " + respuestaConteo.getCantidadLineasTotal() + "<br/>";        
        System.out.println("Complejidad ciclomática: " + respuestaConteo.getComplejidadMcCabeTotal());
        respuesta +="Complejidad ciclomática: " + respuestaConteo.getComplejidadMcCabeTotal() + "<br/>";                
        System.out.println("Resumen de Clases ");
        respuesta +="<b>Resumen de Clases</b> <br/>";      
        respuesta +="<ul>";
        for (Clase clase : clases) {            
            System.out.println("\tNombre de la clase: " + clase.getNombre());
            respuesta +="<li>Nombre de la clase: " + clase.getNombre()+"</li>";
            System.out.println("\tCantidad líneas de la clase: " + clase.getCantidadLineasClase());
            respuesta +="<li>Cantidad líneas de la clase: " + clase.getCantidadLineasClase()+"</li>";
            System.out.println("");
            List<Metodo> metodos = clase.getListaMetodos();
            System.out.println("\t\tResumen de métodos: ");
            respuesta +="<br/>";
            respuesta +="<ul><b>Resumen de métodos:</b>";
            for (Metodo metodo : metodos) {
                System.out.println("\t\tNombre del método: " + metodo.getNombre());
                respuesta +="<li>Nombre del método: " + metodo.getNombre()+"</li>";
                System.out.println("\t\tCantidad líneas del método: " + metodo.getCantidadLineasMetodo());
                respuesta +="<li>Cantidad líneas del método: " + metodo.getCantidadLineasMetodo()+"</li>";
                System.out.println("\t\tComplejidad ciclomática: " + metodo.getComplejidadMcCabe());
                respuesta +="<li>Complejidad ciclomática: " + metodo.getComplejidadMcCabe()+"</li>";
                respuesta +="<br/>";
            }
            respuesta +="</ul>";
            System.out.println("");
            
        }
        respuesta +="</ul>";
        return respuesta;
    }
}
