package edu.uniandes.ms.controlador;


import edu.uniandes.ms.vista.VistaTexto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase principal
 * @author Angela Edith Suárez Torres
 * @version 1.0
 * fecha 04/04/15
 */
public class Main {

    /**
     * Método principal que inicia llamado a analizador
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            VistaTexto vistaTexto = new VistaTexto();
            vistaTexto.analizarDirectorioFuente();
    }

}
