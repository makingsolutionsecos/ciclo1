
package edu.uniandes.ms.modelo;

import edu.uniandes.ms.dto.RespuestaAnalisis;
import edu.uniandes.ms.dto.RespuestaConteo;
import java.io.File;
import java.util.LinkedList;

/**
 * Clase encargada de generar un análisis por cada archivo de un directorio y extensión definido.
 * @author Johans Gonzalez
 * Fecha 3/04/2015
 * @version 1.0
 */

public class Analizador {
    
    /**
     * Método encargado de retornar un objeto con el análisis desarrollado.
     * @param ruta String Variable que contiene la ubicación del directorio a examinar.
     * @param lenguaje LenguajeEnum Objeto que contiene el lenguaje que determina la extensión y lineamientos para desarrollar el análisis.
     * @return un objeto de tipo RespuestaAnalisis con el anñalisis desarrollado.
     */
    public RespuestaAnalisis analizarDirectorioFuente(String ruta, LenguajeEnum lenguaje) {
        RespuestaAnalisis respuestaAnalisis = new RespuestaAnalisis();

        //Buscar Archivos
        Buscador buscador = new Buscador();
        LinkedList<File> archivos = buscador.getArchivos(ruta);
        RespuestaConteo respuesta = new RespuestaConteo();

        //Conteo
        for (File archivo : archivos) {
            IContador contador = FabricaContador.getInstancia(lenguaje);
            contador.ejecutarConteo(archivo, respuesta);
        }
        
        respuestaAnalisis.setRespuestaConteo(respuesta);
        
        return respuestaAnalisis;
    }
}
