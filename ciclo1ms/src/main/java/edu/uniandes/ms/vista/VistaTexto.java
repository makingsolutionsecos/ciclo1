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
     * obtiene su respectivo an�lisis.
     *
     */
    @Override
    public String analizarDirectorioFuente(LenguajeEnum lenguaje) {

        // Para el ciclo 1 el lenguaje y la ruta del c�digo fuente se van a dejar quemados.       
        File directorio = new File(System.getProperty("user.dir") + File.separator + 
                "target" + File.separator + "classes" +
                File.separator + "src");

        Controlador controlador = new Controlador();        
        return pintar(controlador.analizarDirectorioFuente(directorio.getPath(), lenguaje));
    }

    /**
     * M�todo encargado de pintar la respuesta del an�lisis del c�digo fuente
     * analizado.
     *
     * @param respuestaAnalisis Respuesta que contiene el an�lisis detallado del
     * c�digo fuente analizado.
     * @return Respuesta
     */
    @Override
    public String pintar(RespuestaAnalisis respuestaAnalisis) {
        String respuesta = "";
        System.out.println("Proyecto: Ciclo #1 TSP");
        respuesta = "<b>Proyecto: Ciclo #1 TSP</b> <br/>";
        RespuestaConteo respuestaConteo = respuestaAnalisis.getRespuestaConteo();
        List<Clase> clases = respuestaConteo.getListaClases();
        System.out.println("N�mero de clases: " + respuestaConteo.getNumeroClases());
        respuesta +="N�mero de clases: " + respuestaConteo.getNumeroClases()+"<br/>";
        System.out.println("N�mero de l�neas total: " + respuestaConteo.getCantidadLineasTotal());
        respuesta +="N�mero de l�neas total: " + respuestaConteo.getCantidadLineasTotal() + "<br/>";        
        System.out.println("Complejidad ciclom�tica: " + respuestaConteo.getComplejidadMcCabeTotal());
        respuesta +="Complejidad ciclom�tica: " + respuestaConteo.getComplejidadMcCabeTotal() + "<br/>";                
        System.out.println("Resumen de Clases ");
        respuesta +="<b>Resumen de Clases</b> <br/>";      
        respuesta +="<ul>";
        for (Clase clase : clases) {            
            System.out.println("\tNombre de la clase: " + clase.getNombre());
            respuesta +="<li>Nombre de la clase: " + clase.getNombre()+"</li>";
            System.out.println("\tCantidad l�neas de la clase: " + clase.getCantidadLineasClase());
            respuesta +="<li>Cantidad l�neas de la clase: " + clase.getCantidadLineasClase()+"</li>";
            System.out.println("");
            List<Metodo> metodos = clase.getListaMetodos();
            System.out.println("\t\tResumen de m�todos: ");
            respuesta +="<br/>";
            respuesta +="<ul><b>Resumen de m�todos:</b>";
            for (Metodo metodo : metodos) {
                System.out.println("\t\tNombre del m�todo: " + metodo.getNombre());
                respuesta +="<li>Nombre del m�todo: " + metodo.getNombre()+"</li>";
                System.out.println("\t\tCantidad l�neas del m�todo: " + metodo.getCantidadLineasMetodo());
                respuesta +="<li>Cantidad l�neas del m�todo: " + metodo.getCantidadLineasMetodo()+"</li>";
                System.out.println("\t\tComplejidad ciclom�tica: " + metodo.getComplejidadMcCabe());
                respuesta +="<li>Complejidad ciclom�tica: " + metodo.getComplejidadMcCabe()+"</li>";
                respuesta +="<br/>";
            }
            respuesta +="</ul>";
            System.out.println("");
            
        }
        respuesta +="</ul>";
        return respuesta;
    }
}
