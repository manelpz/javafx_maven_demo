package com.example.controllers;


import com.example.model.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class menuController {
    

    @FXML private TextField tfId;
    @FXML private TextField tfTitle;
    @FXML private TextField tfAuthor;
    @FXML private TextField tfYear;
    @FXML private TextField tfPages;

    @FXML
    private void handleBtnAction(javafx.event.ActionEvent event) {  

       // System.out.println("Button clicked!");
        insertBook();
        
    }

    private void insertBook(){

        try {
            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String author = tfAuthor.getText();
            int year = Integer.parseInt(tfYear.getText());
            int pages = Integer.parseInt(tfPages.getText());

             System.out.println("Button clicked! "+id+" "+title+" "+author+" "+year+" "+pages);
             
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Insert Failed");
            alert.setContentText("Invalid type values.");
            alert.showAndWait();
        }
    }

    @FXML 
    private TableView<Book> tbBooks;

    @FXML 
    private TableColumn<Book, Integer> colId;

    @FXML 
    private TableColumn<Book, String> colTitle;

    @FXML 
    private TableColumn<Book, String> colAuthor;

    @FXML 
    private TableColumn<Book, Integer> colYear;

    @FXML 
    private TableColumn<Book, Integer> colPages;

    private ObservableList <Book> bookList = FXCollections.observableArrayList();






}
