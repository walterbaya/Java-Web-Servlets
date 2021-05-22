package ar.com.eduit.resource;

import ar.com.eduit.entidades.Producto;
import ar.com.eduit.repository.ProductoRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoRepository productoRepository;
        productoRepository = new ProductoRepository(cnx);
        String sId = request.getParameter("id");
        Long id = Long.parseLong(sId);
        productoRepository.delete(id);
        List<Producto> productos = productoRepository.getAll();
        request.getSession().setAttribute("productos", productos);
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoRepository productoRepository;
        productoRepository = new ProductoRepository(cnx);

        String presentacion = request.getParameter("presentacion");
        String sCantidad = request.getParameter("cantidad");
        String sPrecio = request.getParameter("precio");
        String descripcion = request.getParameter("descripcion");

        List<String> mensajes = new ArrayList();
        float precio = 0.0f;
        try {
            precio = Float.parseFloat(sPrecio);
        } catch (NumberFormatException ex) {
            mensajes.add(sPrecio + "no es un número válido. Ej: 12.15");
        }

        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(sCantidad);
        } catch (NumberFormatException ex) {
            mensajes.add(sCantidad + "no es un número válido. Ej: 15");
        }

        if (mensajes.isEmpty()) {
            Producto producto = new Producto(presentacion, cantidad, precio, descripcion);
            productoRepository.save(producto);
            List<Producto> productos = productoRepository.getAll();
            mensajes.add("Registrado con Exito");
            request.getSession().setAttribute("productos", productos);
        }

        request.getSession().setAttribute("mensajes", mensajes);
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
