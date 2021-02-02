package web;

import dao.BookDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    private static Connection cnx = null;
    private List<Book> books;

    @Override
    public final void init() throws ServletException {
        this.books = new ArrayList<Book>();
        try {
            cnx = obtener();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Connection obtener() throws SQLException, ClassNotFoundException {
        try {
            if (cnx == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/webbook", "root", "astinm345");
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

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        BookDao dao = new BookDao(cnx);

        String act = request.getParameter("act");
        String deleteText = request.getParameter("deleteInput");
        String searchText = request.getParameter("searchInput");
        String insertText = request.getParameter("insertInput");
        String updateText = request.getParameter("updateInput");

        if ("".equals(act)) {

        } else if ("delete".equals(act)) {
            int i = Integer.parseInt(deleteText);
            dao.delete(i);
            request.getSession().setAttribute("books", books);
        } else if ("insert".equals(act)) {
            String[] words = insertText.split(",");
            Book book = new Book(words[0], words[1], (float) Float.parseFloat(words[2]));
            books.add(book);
            book.setId(dao.save(book));
            request.getSession().setAttribute("books", books);

        }
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
