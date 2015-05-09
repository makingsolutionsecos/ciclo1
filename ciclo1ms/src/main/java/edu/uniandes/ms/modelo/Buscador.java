package edu.uniandes.ms.modelo;

import java.io.File;
import java.util.LinkedList;
import java.lang.UnsupportedOperationException;

/**
 * Clase encargada de buscar los archivos en un directorio con una extensión
 * específica.
 *
 * @author Johans Gonzalez Fecha 4/04/2015
 * @version 1.0
 */
public class Buscador {

    /**
     * Método encargado de retornar el listado de archivos de un directorio.
     *
     * @param path String Variable que contiene la ubicación del directorio a
     * examinar.
     * @param lenguaje de los archivos a buscar.
     * @return Retorna listado de archivos de un directorio.
     */
    public LinkedList<File> getArchivos(String path, LenguajeEnum lenguaje) {
        File dir = new File(path);
        return getArchivosDirectorio(dir, lenguaje);
    }

    /**
     * Método encargado de buscar los archivos de una extensión especifica en un
     * directorio.
     *
     * @param dir File Variable que contiene el directorio en el cual se
     * desarrollara la búsqueda.
     * @return Retorna listado de archivos de un directorio.
     */
    private LinkedList<File> getArchivosDirectorio(File dir, LenguajeEnum lenguaje) {
        LinkedList<File> archivos = new LinkedList<>();
        File listFile[] = dir.listFiles();
        if (listFile != null) {
            for (File archivo : listFile) {
                if (archivo.isDirectory()) {
                    archivos.addAll(getArchivosDirectorio(archivo, lenguaje));
                } else {
                    switch (lenguaje) {
                        case JAVA:
                            if (archivo.getName().endsWith(".java")) {
                                archivos.add(archivo);
                            }
                            break;
                        default:
                            throw new UnsupportedOperationException("No se ha implementado la lectura de archivos de tipo: " + lenguaje);
                    }
                }
            }
        }
        
        return archivos;
    }
}
