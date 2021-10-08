package Base;

import java.util.TreeMap;

public class BaseDeDatos {

    private TreeMap<Double, String> base = new <Double, String>TreeMap();

    public BaseDeDatos() {

    }

    public String obtenerNombreCliente(Double dni) {
        return base.get(dni);
    }

    public String insertarCliente(Double dni, String nombre) {
        return base.put(dni, nombre);
    }

}
