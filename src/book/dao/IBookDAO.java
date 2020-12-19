/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.dao;

import book.entities.Book;
import java.util.List;

/**
 *
 * @author Hai Phuong
 */
public interface IBookDAO {
    public List<Book> listBook();
    public void addBook(Book book);
    public Book findById(String id);
    public void updateBook(Book book);
    public void removeBook(String id);
}
