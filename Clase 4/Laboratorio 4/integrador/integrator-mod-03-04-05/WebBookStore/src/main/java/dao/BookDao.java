package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    public Integer update(Book b) {
        int respuesta = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE books SET title=?,author=?,price=? WHERE id = ?");
            preparedStatement.setInt(1, b.getId());
            preparedStatement.setString(2, b.getTitle());
            preparedStatement.setString(3, b.getAuthor());
            preparedStatement.setFloat(4, b.getPrice());
            respuesta = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error actualizando en la base de datos " + ex);
        }
        return respuesta;
    }

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
        public List<Book> getAll() {
        List<Book> books = new ArrayList();
        try {
            Statement preparedStatement = connection.createStatement();
            ResultSet rs = preparedStatement.executeQuery("SELECT * FROM books");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                Float price = rs.getFloat("price");
                Book b = new Book(title, author, price);
                b.setId(id);
                books.add(b);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error consultando en  la base de datos " + ex);
        }
        return books;
    }
        
    public Book get(int id) {
        Book b = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int Id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                Float price = rs.getFloat("price");
                b = new Book(title,author,price);
                b.setId(Id);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error obteniendo de la base de datos " + ex);
        }
        return b;
    }
    
    public void deleteAll() throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE * FROM books");
        preparedStatement.executeUpdate();
    }
}
