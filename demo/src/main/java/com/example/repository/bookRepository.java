package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.model.Book;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class bookRepository {


    public ObservableList<Book> getBooks() throws Exception{

        ObservableList<Book> lista = FXCollections.observableArrayList();

        Connection conn = DBConnection.getConnection();

        String selectQuery ="select * from books";

        PreparedStatement script = conn.prepareStatement(selectQuery);
        ResultSet rs =  script.executeQuery();

        while(rs.next()){

            Book newbook =new Book(
                rs.getInt("id"),  rs.getString("title"), rs.getString("author"),rs.getInt("year"),rs.getInt("pages")
            );
            lista.add(newbook);        }

        return lista;
    }

    public void insertBook(Book newBook){

        try {
            Connection conn = DBConnection.getConnection();
            String sqlInsert = "insert into books (title, author, year, pages) values (?,?,?,?)";
            PreparedStatement script = conn.prepareStatement(sqlInsert);

            script.setString(1, newBook.getTitle());
            script.setString(2, newBook.getAuthor());
            script.setInt(3, newBook.getYear());
            script.setInt(4, newBook.getPages());

            script.executeUpdate();

        } catch (Exception e) {
          
            e.printStackTrace();
        }

    }


        public void deleteBook(Book deleteBook){

        try {
            Connection conn = DBConnection.getConnection();
            String sqlDelete = "delete from books where id=?";
            PreparedStatement script = conn.prepareStatement(sqlDelete);
            script.setInt(1, deleteBook.getId());
         
            script.executeUpdate();

        } catch (Exception e) {
          
            e.printStackTrace();
        }

    }

        public void updateBook(Book modifiedBook){

        try {
            Connection conn = DBConnection.getConnection();
            String sqlUpdate = "update books set title = ?, author = ?, year = ?, pages=? where id = ?";
            PreparedStatement script = conn.prepareStatement(sqlUpdate);

            
            script.setString(1, modifiedBook.getTitle());
            script.setString(2, modifiedBook.getAuthor());
            script.setInt(3, modifiedBook.getYear());
            script.setInt(4, modifiedBook.getPages());
            script.setInt(5, modifiedBook.getId());

            script.executeUpdate();

        } catch (Exception e) {
          
            e.printStackTrace();
        }

    }
    
    
}
