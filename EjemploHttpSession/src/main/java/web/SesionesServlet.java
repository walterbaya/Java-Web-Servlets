package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WalterAriel
 */
@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset-UTF-8");
        HttpSession sesion = request.getSession();
        String titulo = null;
        Integer contadorVisitas = (Integer) (sesion.getAttribute("contadorVisitas"));
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido por vez numero";
        }
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        PrintWriter out = response.getWriter();
        out.print(titulo);
        out.print("<br>");
        out.print("no. accesos al recurso:" + contadorVisitas);
        out.print("<br>");
        out.print("ID de la sesion: " + sesion.getId());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
