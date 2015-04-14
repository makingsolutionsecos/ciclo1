package edu.uniandes.ms.dto;

/**
 * Clase DTO que contiene la estructura de la respuesta de análisis
 * @author Camilo Marroquin
 * @version 1.0
 * Fecha 02/04/2015
 */
public class RespuestaAnalisis {
    
    /**
     * Resultado del conteo
     */
    private RespuestaConteo respuestaConteo;

    /**
     * Nombre del Proyecto (Directorio)
     */
    private String nombreProyecto;

    /**
     * Obtiene el nombre del Proyecto
     * @return String Nombre del Proyecto 
     */
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    /**
     * Establecer el nombre de Proyecto
     * @param nombreProyecto 
     */
    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
    
    /**
     * Obtiene la respuesta de conteo
     * @return 
     */
    public RespuestaConteo getRespuestaConteo() {
        return respuestaConteo;
    }

    /**
     * Establecer la respuesta del conteo
     * @param respuestaConteo 
     */
    public void setRespuestaConteo(RespuestaConteo respuestaConteo) {
        this.respuestaConteo = respuestaConteo;
    }

    /**
     * Constructor de la clase
     * Inicializa la respuesta del conteo
     */
    public RespuestaAnalisis() {
        this.respuestaConteo = new RespuestaConteo();
    }
}


