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
    
    
}
