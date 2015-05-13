/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ms.controlador;

import edu.uniandes.ms.dto.RespuestaAnalisis;
import edu.uniandes.ms.modelo.Analizador;
import edu.uniandes.ms.modelo.LenguajeEnum;

/**
 * Clase Controlador que llama a el analizador y ejecuta el analisis de un
 * directorio
 *
 * @author Jorge Beltr�n
 * @version 1.0 Fecha 01/04/2015
 */
public class Controlador {

    /**
     * M�todo que permite analizar c�digo fuente.
     * @param ruta del folder donde se encuentra alojado el c�digo fuente.
     * @param lenguaje en el que esta escrito el c�digo.
     * @return 
     */
    public RespuestaAnalisis analizarDirectorioFuente(String ruta, LenguajeEnum lenguaje) {
        Analizador analizador = new Analizador();
        return analizador.analizarDirectorioFuente(ruta, lenguaje);
    }
}
