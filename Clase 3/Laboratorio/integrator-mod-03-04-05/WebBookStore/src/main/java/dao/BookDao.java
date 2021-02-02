package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Book;

public class BookDao {

    private Connection connection;

    public BookDao(Connection connection) {
        this.connection = connection;
    }

    public int save(Book b) {
        int result = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (title,author,price) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, b.getTitle());
            preparedStatement.setString(2, b.getAuthor());
            preparedStatement.setFloat(3, b.getPrice());
            preparedStatement.executeUpdate();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()){
                result = rs.getInt(1);
            }
            else{
               throw new RuntimeException("Hubo un error con el result Set");
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Error grabando en la base de datos " + ex);
        }
        return result;
    }

    /*
    public Integer update(Producto p) {
        int respuesta = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update productos set presentacion=?, cantidad=?,precio=?,descripcion=? where id = ?");
            preparedStatement.setString(1, p.getPresentacion());
            preparedStatement.setInt(2, p.getCantidad());
            preparedStatement.setFloat(3, p.getPrecio());
            preparedStatement.setString(4, p.getDescripcion());
            preparedStatement.setLong(5, p.getId());
            respuesta = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error actualizando en la base de datos " + ex);
        }
        return respuesta;
    }
*/
    public Integer delete(int id) {
        int respuesta = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books where id = ?");
            preparedStatement.setInt(1, id);
            respuesta = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error eliminando en la base de datos " + ex);
        }
        return respuesta;
    }
/*
    public Producto get(Long id) {
        Producto p = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from productos where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String presentacion = rs.getString("presentacion");
                Integer cantidad = rs.getInt("cantidad");
                Float precio = rs.getFloat("precio");
                String descripcion = rs.getString("descripcion");
                p = new Producto(id, presentacion, cantidad, precio, descripcion);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error obteniendo de la base de datos " + ex);
        }
        return p;
    }

    public List<Producto> getAll() {
        List<Producto> productos = new ArrayList();
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery("select * from productos");
            while (rs.next()) {
                Long id = rs.getLong("id");
                String presentacion = rs.getString("presentacion");
                Integer cantidad = rs.getInt("cantidad");
                Float precio = rs.getFloat("precio");
                String descripcion = rs.getString("descripcion");
                Producto p = new Producto(id, presentacion, cantidad, precio, descripcion);
                productos.add(p);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error consultando en  la base de datos " + ex);
        }
        return productos;
    }
     */
}
