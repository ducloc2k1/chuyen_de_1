/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.dao;

import book.entities.Book;
import book.help.SqlConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hai Phuong
 */
public class BookDAO implements IBookDAO{

    @Override
    public List<Book> listBook() {
        List<Book> books = new ArrayList<>();
        Book book;
        ResultSet resultSet = SqlConnection.executeQuery("{call ListAllBook()}");
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    book = new Book();
                    book.setId(resultSet.getString("id"));
                    book.setTitle(resultSet.getString("title"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setPublishing(resultSet.getString("publishing"));
                    book.setYear(resultSet.getInt("year"));
                    book.setPrice(resultSet.getFloat("price"));
                    book.setDateType(resultSet.getDate("dateType"));
                    books.add(book);
                }
                return books;
            } catch (SQLException ex) {
                Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Không có bản ghi");
        }
        return null;
    }

    @Override
    public void addBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Book findById(String id) {
        ResultSet rs = SqlConnection.executeQuery("{call findById(?)}", id);
        try {
            rs.next();
            Book book = new Book(rs.getString("id"), rs.getString("title"), rs.getString("author"), 
                                rs.getString("publishing"), rs.getInt("year"), rs.getFloat("price"), 
                                rs.getDate("dateType"));
            return book;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void updateBook(Book book) {
        SqlConnection.executeUpdate("{call UpdateBook(?,?,?,?,?,?,?)}", 
                book.getId(), book.getTitle(), book.getAuthor(), book.getPublishing(),
                book.getYear(), book.getPrice(),book.getDateType());
    }

    @Override
    public void removeBook(String id) {
        SqlConnection.executeUpdate("{call RemoveBook(?)}", id);
    }
    
    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        bookDAO.listBook();
    }
}
