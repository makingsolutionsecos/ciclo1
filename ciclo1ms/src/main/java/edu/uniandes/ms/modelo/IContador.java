package edu.uniandes.ms.modelo;

import edu.uniandes.ms.dto.RespuestaConteo;
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Interface que expone el m�todo que implementara la l�gica para ejecutar el
 * conteo
 *
 * @author Angela Edith Su�rez Torres
 * @version 1.0
 * @fecha 03/04/15
 */
public interface IContador {

    /**
     * M�todo que recibe un archivo sobre el cual ejecutar� el conteo
     *
     * @param archivo
     * @param respuestaConteo
     */
    public void ejecutarConteo(File archivo, RespuestaConteo respuestaConteo);
}
