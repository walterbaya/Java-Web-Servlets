package ar.com.eduit.command;

import ar.com.eduit.entidades.Producto;
import ar.com.eduit.repository.ProductoRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class SaveCommand implements Command {

    @Override
    public String execute(ProductoRepository productoRepository, HttpServletRequest request) {
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
            mensajes.add("Registrado con Exito");

            ListCommand listcommand = new ListCommand();
            listcommand.execute(productoRepository, request);
        }
        request.getSession().setAttribute("mensajes", mensajes);
        return "index.jsp";
    }

}
