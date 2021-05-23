package ar.com.eduit.resource;

import ar.com.eduit.command.Command;
import ar.com.eduit.repository.ProductoRepository;
import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoController", urlPatterns = {"/producto"})
public class ProductoController extends HttpServlet {

    private static Connection cnx = null;
    private Map<String, Command> commands;
    private ResourceBundle resourceBundle;

    @Override
    public final void init() throws ServletException {
        try {
            cnx = obtener();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        commands = new HashMap();
        resourceBundle = ResourceBundle.getBundle("config");
        Enumeration<String> keys = resourceBundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = resourceBundle.getString(key);
            Class clazz;
            try {
                clazz = Class.forName(value);
                Command command = (Command) clazz.newInstance();
                commands.put(key, command);
            } catch (InstantiationException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ProductoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Connection obtener() throws SQLException, ClassNotFoundException {
        try {
            if (cnx == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "astinm345");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error conectando con la base de datos " + ex);
        }
        return cnx;
    }

    //Procesa cualquier tipo de request, no importa si es post o get.
    //desde doPost y doGet llamamos a este processRequest para procesar el request
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductoRepository productoRepository;
        productoRepository = new ProductoRepository(cnx);
        String userCommand = request.getParameter("command");
        Command command = commands.get(userCommand);
        String redirect = command.execute(productoRepository, request);
        response.sendRedirect(redirect);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
