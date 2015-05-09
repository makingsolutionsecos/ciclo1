package edu.uniandes.ms.vista;

import edu.uniandes.ms.dto.RespuestaAnalisis;
import edu.uniandes.ms.modelo.LenguajeEnum;

/**
 * Interfaz que contiente las definiciones de un grupo de funciones relacionadas
 * con la solicitud y generación del análisis de código.
 *
 * @author John Dany osorio Ramos
 * @version 1.0
 * Fecha: 04/04/2015 
 */
public interface IVista {

    /**
     * Define el método que analiza el código fuente de un lenguaje en
     * específico y se optiene su respectivo análisis.
     * @param lenguaje a analizar.
     * @return 
     */
    public String analizarDirectorioFuente(LenguajeEnum lenguaje);

    /**
     * Define el método encargado de pintar la respuesta del análisis del código
     * fuente analizado.
     *
     * @param respuestaAnalisis Respuesta que contiene el análisis detallado del
     * código fuente analizado.
     * @return 
     */
    public String pintar(RespuestaAnalisis respuestaAnalisis);
}
