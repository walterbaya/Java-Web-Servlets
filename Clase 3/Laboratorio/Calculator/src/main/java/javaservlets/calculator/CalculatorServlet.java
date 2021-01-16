package javaservlets.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author WalterAriel
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/action"})
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String operation = request.getParameter("operation");
        String operator1 = request.getParameter("operator1");
        String operator2 = request.getParameter("operator2");

        double aux=0;
        double number1 = Double.valueOf(operator1);
        double number2 = Double.valueOf(operator2);
        
        if("substraction".equals(operation)){
            aux = number1 - number2;
        }
        if("product".equals(operation)){
            aux = number1*number2;
        }
        if("divide".equals(operation)){
            aux = number1/number2;
        }
        if(!"adition".equals(operation)){
            aux = number1 + number2;
        }
        
        String result = String.valueOf(aux);
        
        response.sendRedirect("index.jsp?result= " + result);
    }

}
