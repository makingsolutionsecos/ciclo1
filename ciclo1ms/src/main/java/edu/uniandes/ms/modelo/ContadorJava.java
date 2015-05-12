package edu.uniandes.ms.modelo;

import edu.uniandes.ms.dto.Clase;
import edu.uniandes.ms.dto.Metodo;
import edu.uniandes.ms.dto.RespuestaConteo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Clase que contiene los métodos que implementan la lógica de conteo
 * @author Angela Edith Suárez Torres
 * @version 1.0
 * fecha 04/04/15
 */
public class ContadorJava implements IContador {

    /**
     * Recibe un archivo como parámetro para conteo y recibe respuesta que será actualizada por referencia
     * @param archivo
     * @param respuestaConteo 
     */
    @Override
    public void ejecutarConteo(File archivo, RespuestaConteo respuestaConteo) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(archivo.getPath());
            BufferedReader br = new BufferedReader(fileReader);

            Clase clase = null;
            Metodo metodo = null;
            //Contiene la lista de clases con su correspondiente ejecución de conteo
            List<Clase> clases = respuestaConteo.getListaClases();
            while (br.ready()) {
                String s = br.readLine();
                if (isClassLine(s)) {
                    if (clase != null) {
                        clases.add(clase);
                    }
                    clase = new Clase();
                    clase.setNombre(archivo.getName());
                    clase.setCantidadLineasClase(clase.getCantidadLineasClase() + 1);
                } else if (isMethodLine(s)) {
                    if (metodo != null) {
                        clase.addMetodo(metodo);
                    }
                    metodo = new Metodo();
                    metodo.setNombre(getNombreMetodo(s.trim()));
                    clase.setCantidadLineasClase(clase.getCantidadLineasClase() + 1);
                    metodo.setCantidadLineasMetodo(metodo.getCantidadLineasMetodo() + 1);                    
                    metodo.setComplejidadMcCabe(metodo.getComplejidadMcCabe() + 1);
                    clase.setComplejidadMcCabe(clase.getComplejidadMcCabe() + 1);

                } else if (isCodeLine(s)) {
                    if (clase != null) {
                        clase.setCantidadLineasClase(clase.getCantidadLineasClase() + 1);
                    }
                    if (metodo != null) {
                        metodo.setCantidadLineasMetodo(metodo.getCantidadLineasMetodo() + 1);                        
                        metodo.setComplejidadMcCabe(metodo.getComplejidadMcCabe() + valueExpressionMcCabe(s));
                        clase.setComplejidadMcCabe(clase.getComplejidadMcCabe() + valueExpressionMcCabe(s));
                    }
                }
            }
            if (metodo != null) {
                clase.addMetodo(metodo);
            }
            clases.add(clase);
            respuestaConteo.setListaClases(clases);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContadorJava.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ContadorJava.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileReader.close();
            } catch (IOException ex) {
                Logger.getLogger(ContadorJava.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    /**
     * Evalua si la línea de código analizada corresponde a la
     * declaración de una clase
     * @param input
     * @return resultado de evaluación
     */
    public boolean isClassLine(String input) {
        return input.trim().matches("public (class |enum |interface ){1}.*");
    }
    /**
     * Evalua si la línea de código analizada corresponde a la
     * declaración de un método
     * @param input
     * @return resultado de evaluación
     */
    public boolean isMethodLine(String input) {
        return input.trim().matches("(public |private |protected ){1}.*(\\().*");
    }
    /**
     * Evalua si la línea de código analizada no corresponde a la
     * declaración de un método o una clase
     * @param input
     * @return resultado de evaluación
     */
    public boolean isCodeLine(String input) {
        return input.trim().matches("([^(\\/|\\*|\\{|\\@].*)") && !input.trim().equals("}");
    }

    /**
     * Obtiene el nombre del método analizado
     * @param linea
     * @return String con nombre del método 
     */
    public String getNombreMetodo(String linea){
        int indexParentesis = linea.indexOf("(");
        linea = linea.substring(0, indexParentesis);
        linea = linea.substring(linea.lastIndexOf(" ")+1, linea.length());
        return linea;
    }
    
    private int valueExpressionMcCabe(String linea){
        int vExpressionMcCabe = 0;
        String lineaCodigo = linea.replaceAll(" ","");
        Pattern pattern = Pattern.compile("^if\\(.*\\)\\{$");
        Matcher matcher = pattern.matcher(lineaCodigo);
        if (matcher.matches()){
            vExpressionMcCabe++;
            String[] numeroCondiciones = lineaCodigo.split("&&");
            vExpressionMcCabe = (numeroCondiciones.length - 1) + vExpressionMcCabe;
            numeroCondiciones = lineaCodigo.split("\\|\\|");
            vExpressionMcCabe = (numeroCondiciones.length - 1) + vExpressionMcCabe;
        }
        
        pattern = Pattern.compile("^elseif\\(.*\\)\\{$");
        matcher = pattern.matcher(lineaCodigo);
        if (matcher.matches()){
            vExpressionMcCabe++;
            String[] numeroCondiciones = lineaCodigo.split("&&");
            vExpressionMcCabe = (numeroCondiciones.length - 1) + vExpressionMcCabe;
            numeroCondiciones = lineaCodigo.split("\\|\\|");
            vExpressionMcCabe = (numeroCondiciones.length - 1) + vExpressionMcCabe;
        }       
        
        pattern = Pattern.compile("^case.*:$");
        matcher = pattern.matcher(lineaCodigo);
        if (matcher.matches()) {
            vExpressionMcCabe++;
        }
        
        pattern = Pattern.compile("^for\\(.*\\)\\{$"); 
        matcher = pattern.matcher(lineaCodigo);
        if (matcher.matches()) {
            vExpressionMcCabe++;
        }
        
        pattern = Pattern.compile("^foreach\\(.*\\)\\{$"); 
        matcher = pattern.matcher(lineaCodigo);
        if (matcher.matches()) {
            vExpressionMcCabe++;
        }
        
        pattern = Pattern.compile("^while\\(.*\\)\\{$"); 
        matcher = pattern.matcher(lineaCodigo);
        if (matcher.matches()) {
            vExpressionMcCabe++;
        }
        
        pattern = Pattern.compile("^\\}catch\\(.*\\)\\{$"); 
        matcher = pattern.matcher(lineaCodigo);
        if (matcher.matches()) {
            vExpressionMcCabe++;
        }
               
        return vExpressionMcCabe;
    }
    
    
}
