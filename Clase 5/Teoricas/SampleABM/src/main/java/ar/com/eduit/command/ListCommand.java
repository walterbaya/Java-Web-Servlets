package ar.com.eduit.command;

import ar.com.eduit.entidades.Producto;
import ar.com.eduit.repository.ProductoRepository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class ListCommand implements Command {

    @Override
    public String execute(ProductoRepository productoRepository, HttpServletRequest request) {
        List<Producto> productos = productoRepository.getAll();
        request.getSession().setAttribute("productos", productos);
        return "index.jsp";
    }

}
