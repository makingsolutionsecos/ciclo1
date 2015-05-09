package edu.uniandes.ms.controlador;

import edu.uniandes.ms.modelo.LenguajeEnum;
import edu.uniandes.ms.vista.VistaTexto;
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
 * Clase principal
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
//            Server server = new Server(Integer.valueOf(System.getenv("PORT")));
            Server server = new Server(Integer.valueOf("8080"));
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
     * Metodo post que se ejecuta cuando hay un submit obtiene los valores
     * digitados en pantalla
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        VistaTexto vistaTexto = new VistaTexto();
        String respuesta = vistaTexto.analizarDirectorioFuente(LenguajeEnum.JAVA);
        PrintWriter out = resp.getWriter();
        out.print("<html>\n"
                + "<body>\n"
                + "<form>\n"
                +respuesta +"\n"                
                + "</form>\n"
                + "</body>\n"
                + "</html>");
    }

    /**
     * Metodo que carga la pantalla en html
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html>\n"
                + "<body>\n"
                + "<form action=\"VistaWeb\" method=\"POST\">\n"
                +"<input type='submit'/>"     
                + "</form>\n"
                + "</body>\n"
                + "</html>");
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
    }

}
