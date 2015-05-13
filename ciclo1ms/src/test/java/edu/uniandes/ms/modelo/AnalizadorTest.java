/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ms.modelo;

import edu.uniandes.ms.dto.RespuestaAnalisis;
import java.io.File;
import junit.framework.TestCase;

/**
 * Test of AnalizadorTest method, of class Analizador.
 *
 * @author John Dany osorio Ramos
 */
public class AnalizadorTest extends TestCase {

    public AnalizadorTest(String testName) {
        super(testName);
    }

    /**
     * Test of analizarDirectorioFuente method, of class Analizador.
     */
    public void testAnalizarDirectorioFuente() {
        Analizador analizador = new Analizador();
        File directorio = new File(System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "testUnitario");
        //Se analizara en la ruta que contiene el archivo Buscador.java     
        RespuestaAnalisis respuesta = analizador.analizarDirectorioFuente(directorio.getPath(), LenguajeEnum.JAVA);
        assertNotNull("Respuesta nula.", respuesta);
        assertNotNull("No se obtuvo respuesta de conteno.", respuesta.getRespuestaConteo());
        assertNotNull("No se obtuvieron archivos de código de fuente analizados.", respuesta.getRespuestaConteo().getListaClases());
        assertEquals(1, respuesta.getRespuestaConteo().getListaClases().size());
        assertEquals(2, respuesta.getRespuestaConteo().getListaClases().get(0).getListaMetodos().size());
        //Evaluar complejidad de MC Cabe
        assertEquals(1, respuesta.getRespuestaConteo().getListaClases().get(0).getListaMetodos().get(0).getComplejidadMcCabe());
        assertEquals(6, respuesta.getRespuestaConteo().getListaClases().get(0).getListaMetodos().get(1).getComplejidadMcCabe());
    }

}
