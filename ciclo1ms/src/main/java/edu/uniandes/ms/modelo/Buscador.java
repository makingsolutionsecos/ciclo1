package modelo;

import java.io.File;
import java.util.LinkedList;

/**
 * Clase encargada de buscar los archivos  en un directorio con una extensión específica.
 * @author Johans Gonzalez
 * Fecha 1/04/2015
 * @version 1.0
 */
public class Buscador {
    
    /**
     * Método encargado de retornar  el listado de archivos de un directorio.
     * @param path String Variable que contiene la ubicación del directorio a examinar.
     * @return Retorna listado de archivos de un directorio.
     */    
    public LinkedList<File> getArchivos(String path) {
        File dir = new File(path);
        return getArchivosDirectorio(dir);
    }
    
    /**
     * Método encargado de buscar los archivos de una extensión especifica  en un directorio.
     * @param dir File Variable que contiene el directorio en el cual se desarrollara la búsqueda.
     * @return Retorna listado de archivos de un directorio.
     */    
    private LinkedList<File> getArchivosDirectorio(File dir) {
        LinkedList<File> archivos = new LinkedList<>() ;
        File listFile[] = dir.listFiles();
        if (listFile != null) {
            for (File archivo : listFile) {
                if (archivo.isDirectory()) {
                    archivos.addAll(getArchivosDirectorio(archivo)) ;
                } else if(archivo.getName().endsWith(".java")) {
                    archivos.add(archivo);
//                    System.out.println(archivo.getAbsolutePath());
                }
            }
        }
        return archivos;
    }
}
