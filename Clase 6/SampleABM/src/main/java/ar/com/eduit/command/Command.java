package ar.com.eduit.command;

import ar.com.eduit.repository.ProductoRepository;
import javax.servlet.http.HttpServletRequest;


public interface Command {
    String execute(ProductoRepository productoRespository, HttpServletRequest request);
}
