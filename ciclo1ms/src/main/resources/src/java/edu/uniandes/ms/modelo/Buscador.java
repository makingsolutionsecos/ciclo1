package edu.uniandes.ms.modelo;

import java.io.File;
import java.util.LinkedList;

/**
 * Clase encargada de buscar los archivos  en un directorio con una extensi�n espec�fica.
 * @author Johans Gonzalez
 * Fecha 4/04/2015
 * @version 1.0
 */
public class Buscador {
    
    /**
     * M�todo encargado de retornar  el listado de archivos de un directorio.
     * @param path String Variable que contiene la ubicaci�n del directorio a examinar.
     * @return Retorna listado de archivos de un directorio.
     */    
    public LinkedList<File> getArchivos(String path) {
        File dir = new File(path);
        return getArchivosDirectorio(dir);
    }
    
    /**
     * M�todo encargado de buscar los archivos de una extensi�n espec�fica  en un directorio.
     * @param dir File Variable que contiene el directorio en el cual se desarrollar� la b�squeda.
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
                }
            }
        }
        return archivos;
    }
}
