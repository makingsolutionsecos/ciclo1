package edu.uniandes.ms.controlador;

import edu.uniandes.ms.modelo.LenguajeEnum;
import edu.uniandes.ms.vista.VistaTexto;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Clase principal que inicia la aplicación.
 *
 * @author Angela Edith Suárez Torres
 * @version 1.0 fecha 04/04/15
 */
public class Main extends HttpServlet {

    /**
     * Método principal que inicia llamado a analizador
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Server server = new Server(Integer.valueOf(System.getenv("PORT")));
            //Server server = new Server(Integer.valueOf("8083"));
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            server.setHandler(context);
            context.addServlet(new ServletHolder(new Main()), "/*");
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método post que se ejecuta cuando hay un submit obtiene los valores
     * digitados en pantalla.
     *
     * @param req Solicitud http.
     * @param resp Respuesta de la solitud.
     * @throws ServletException lanzada cuando falle el Servet.
     * @throws IOException lanzada cuando se presente un error relacionado con
     * la entrada y salida.
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String archUp = req.getParameter("archUp");
        PrintWriter out = resp.getWriter();
        if (archUp != null) {
            File directorio = new File(archUp);
            String ruta = directorio.getAbsolutePath();
            VistaTexto vistaTexto = new VistaTexto();
            String respuesta = vistaTexto.analizarDirectorioFuente(ruta, LenguajeEnum.JAVA);
            out.print(cargarPagina2Html(respuesta));
        } else {
            out.print(cargarPagina2Html("Debe seleccionar un archivo comprimido (.zip) para analizar."));
        }
    }

    /**
     * Método que carga la pantalla en html.
     *
     * @param req Solicitud http.
     * @param resp Respuesta de la solitud.
     * @throws ServletException lanzada cuando falle el Servet.
     * @throws IOException lanzada cuando se presente un error relacionado con
     * la entrada y salida.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print(cargarPaginaHtml());
    }

    /**
     * Método que carga la pantalla de inicio.
     *
     * @param req Solicitud http.
     * @param resp Respuesta de la solitud.
     * @throws ServletException lanzada cuando falle el Servet.
     * @throws IOException lanzada cuando se presente un error relacionado con
     * la entrada y salida.
     */
    private void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    /**
     * Método que crea la pantalla inicial.
     *
     * @return una cadena con el formato html de la página.
     */
    private String cargarPaginaHtml() {
        String plantilla = "";

        plantilla = "<html>\n"
                + "    <head>\n"
                + "        <title>TSPi MAKING SOLUTIONS</title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#FBFBEF\">\n"
                + "        <form action=\"VistaWeb\" method=\"post\">\n"
                + "            <table border=\"1\" align=\"center\" bgcolor=\"#E0ECF8\" style=\"border: yellow 9px solid;\"> \n"
                + "                <tr>\n"
                + "                    <td>\n"
                + "                        <h3>Making Solutions</h3>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>\n"
                + "                        <p>Analizador de programas JAVA:</p>\n"
                + "                        <p>Esta aplicación leerá la ruta origen de un proyecto Java y lo analizará obteniendo el siguiente resultado</p>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>\n"
                + "                        <ul>\n"
                + "                            <li>Número de clases</li>\n"
                + "                            <li>Número total de líneas del proyecto</li>\n"
                + "                            <li>Complejidad ciclomática</li>\n"
                + "                            <li>Nombre de una clase</li>\n"
                + "                            <li>LOC por clase</li>\n"
                + "                            <li>Resúmen de métodos por clase</li>\n"
                + "                            <li>Complejidad ciclomática por método</li>\n"
                + "                        </ul>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>\n"
                + "                        <p>Seleccione la ruta fuente de un proyecto Java</p>\n"
                + "                        <br/>\n"
                + "                <center><input type=\"file\" name=\"archUp\" accept=\".zip\"/></center>\n"
                + "                <br/>\n"
                + "                </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>\n"
                + "                <center> <input type=\"submit\" value=\"Analizar\"/></center>\n"
                + "                </td>\n"
                + "                </tr>\n"
                + "            </table>\n"
                + "        </form>              \n"
                + "    </body>\n"
                + "</html>";

        return plantilla;
    }

    /**
     * Método para crear la página de resultado.
     *
     * @param resultado cadena con texto con formato html.
     * @return
     */
    private String cargarPagina2Html(String resultado) {
        String plantilla = "";

        plantilla = "<html>\n"
                + "    <head>\n"
                + "        <title>TSPi MAKING SOLUTIONS</title>\n"
                + "    </head>\n"
                + "    <body bgcolor=\"#FBFBEF\">\n"
                + "        <form action=\"VistaWeb\" method=\"post\">\n"
                + "            <table border=\"1\" align=\"center\" bgcolor=\"#E0ECF8\" style=\"border: yellow 9px solid;\"> \n"
                + "                <tr>\n"
                + "                    <td>\n"
                + "                        <h3>Making Solutions</h3>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>\n"
                + "                        <p>RESULTADO</p>                        \n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td>\n"
                + "<center>"
                + "                        " + resultado + "\n"
                + "</center>"
                + "                    </td>\n"
                + "                </tr>\n"
                + "            </table>\n"
                + "        </form>              \n"
                + "    </body>\n"
                + "</html>";

        return plantilla;
    }

}
