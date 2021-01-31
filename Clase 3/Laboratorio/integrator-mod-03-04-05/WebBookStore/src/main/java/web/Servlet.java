package web;

import dao.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    BookDAO bookDao;

    @Override
    public void init() {

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
        String act = request.getParameter("act");
        String deleteText = request.getParameter("deleteInput");
        String searchText = request.getParameter("searchInput");
        String insertText = request.getParameter("insertInput");
        String updateText = request.getParameter("updateInput");
        String valor = "";
        if (act == null) {

        } else if ("delete".equals(act)) {
            valor = "delete";
            int i = Integer.parseInt(deleteText);
            bookDao.deleteById(i);
            //send message saying the which book is been deleted
        } else if ("insert".equals(act)) {
            valor = "insert";
           
        } else if ("update".equals(act)) {
            valor = "update";
            
        } else {
            valor = "search";
            int i = Integer.parseInt(searchText);
            bookDao.findById(i);
        }

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
