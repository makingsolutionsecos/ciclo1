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
 * Clase Controlador que llama al analizador y ejecuta el análisis de un directorio
 * @author Jorge Beltrán
 * @version 1.0
 * Fecha 01/04/2015
 */
public class Controlador {
    public RespuestaAnalisis analizarDirectorioFuente(String ruta, LenguajeEnum lenguaje) {
        Analizador analizador = new Analizador();
        return analizador.analizarDirectorioFuente(ruta, lenguaje);
    }
}
