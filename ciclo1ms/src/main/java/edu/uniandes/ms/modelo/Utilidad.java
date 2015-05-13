/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ms.modelo;

/**
 * Clase utilitaria.
 *
 * @author Johans Gonzalez
 */
public class Utilidad {

    /**
     * Método que clasifica la complejidad de MC Cabe en un rango de
     * complejidad.
     *
     * @param complejidadMcCabe complejidad a clasificar.
     * @return Descripción de la complejidad.
     */
    public static String equivalenciaComplejidadMcCabe(int complejidadMcCabe) {
        if (complejidadMcCabe < 10) {
            return "Clase simple, sin mucho riesgo.";
        } else if (complejidadMcCabe >= 10 && complejidadMcCabe < 20) {
            return "Clase mediamente compleja, riesgo moderado.";
        } else if (complejidadMcCabe >= 20 && complejidadMcCabe < 50) {
            return "Clase compleja, alto riesgo.";
        } else {
            return "Clase no testeable, riesgo muy alto.";
        }
    }
}
