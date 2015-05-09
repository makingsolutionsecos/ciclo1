package edu.uniandes.ms.vista;

import edu.uniandes.ms.dto.RespuestaAnalisis;
import edu.uniandes.ms.modelo.LenguajeEnum;

/**
 * Interfaz que contiente las definiciones de un grupo de funciones relacionadas
 * con la solicitud y generaci�n del an�lisis de c�digo.
 *
 * @author John Dany osorio Ramos
 * @version 1.0
 * Fecha: 04/04/2015 
 */
public interface IVista {

    /**
     * Define el m�todo que analiza el c�digo fuente de un lenguaje en
     * espec�fico y se optiene su respectivo an�lisis.
     * @param lenguaje a analizar.
     * @return 
     */
    public String analizarDirectorioFuente(LenguajeEnum lenguaje);

    /**
     * Define el m�todo encargado de pintar la respuesta del an�lisis del c�digo
     * fuente analizado.
     *
     * @param respuestaAnalisis Respuesta que contiene el an�lisis detallado del
     * c�digo fuente analizado.
     * @return 
     */
    public String pintar(RespuestaAnalisis respuestaAnalisis);
}
