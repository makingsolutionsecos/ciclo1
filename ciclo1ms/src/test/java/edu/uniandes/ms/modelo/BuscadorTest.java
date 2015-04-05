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
                
        File directorio = new File (".");            
        String ruta = "";
        try {
            ruta = directorio.getCanonicalPath();                                   
        } catch (IOException ex) {            
            fail("No se puede establecer la ruta actual del directorio.");
        }
                
        if(ruta.indexOf("ciclo1ms") != -1){                      
            Buscador buscador = new Buscador();
            LinkedList<File> archivos = buscador.getArchivos(ruta);            
            assertNotNull("No se están detectando los archivos en el directorio.",archivos);                                                  
            assertEquals("No se está detectando la totalidad de los archivos de un directorio.", 15, archivos.size());
        }
        else{
            fail("No se puede establecer la ruta actual del directorio.");
        }
        
    }
        
}
