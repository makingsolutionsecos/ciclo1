package edu.uniandes.ms.modelo;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import junit.framework.TestCase;

/**
 * Pruebas unitarias de la clase buscador.
 * @author Johans Gonzalez
 * Fecha 5/04/2015
 * @version 1.0
 */
public class BuscadorTest extends TestCase {
    
    public BuscadorTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Prueba del metodo getArchivos de la clase Buscador.
     */
    public void testGetArchivos() {
                
        LenguajeEnum lenguaje = LenguajeEnum.JAVA;
        File directorio = new File(System.getProperty("user.dir") + File.separator + 
                "target" + File.separator + "classes" +
                File.separator + "src");

            Buscador buscador = new Buscador();
            LinkedList<File> archivos = buscador.getArchivos(directorio.getPath());            
            assertNotNull("No se están detectando los archivos en el directorio.",archivos);                                                  
            assertEquals("No se está detectando la totalidad de los archivos de un directorio.", 14, archivos.size());
        
        
    }
        
}
