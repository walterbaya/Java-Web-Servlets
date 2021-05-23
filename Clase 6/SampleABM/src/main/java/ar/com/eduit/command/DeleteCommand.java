package ar.com.eduit.command;

import ar.com.eduit.repository.ProductoRepository;
import javax.servlet.http.HttpServletRequest;

public class DeleteCommand implements Command{

    @Override
    public String execute(ProductoRepository productoRepository, HttpServletRequest request) {
        String sId = request.getParameter("id");
        Long id = Long.parseLong(sId);
        productoRepository.delete(id);
        ListCommand listcommand = new ListCommand();
        listcommand.execute(productoRepository, request);
        return "index.jsp";
    }
    
}
