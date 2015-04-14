package edu.uniandes.ms.modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Contiene la implementación del método que retornará la interfaz correspondiente al 
 * tipo de lenguaje a analizar
 * @author Angela Edith Suárez Torres
 * @version 1.0
 * Fecha 02/04/15
 */
public class FabricaContador {
    
    /**
     * Instancia interface de acuerdo al lenguaje a analizar
     * @param lenguaje 
     * @return IContador
     * Fecha 03/04/15
     */
    public static IContador getInstancia(LenguajeEnum lenguaje){
        
        IContador contador;
        
        switch (lenguaje) {
            case JAVA:
                contador = new ContadorJava();
                break;
           // case CSHARP:
                //contador = new ContadorCSharp();
               // break;
            default:
                contador = new ContadorJava();
                break;
        }
        return contador;
    }
}
