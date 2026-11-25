package com.example.controllers;


import com.example.model.Book;
import com.example.repository.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class menuController {
    
    private bookRepository repository = new bookRepository();

    @FXML 
    private TextField tfId;
    
    @FXML 
    private TextField tfTitle;
    
    @FXML 
    private TextField tfAuthor;
    
    @FXML
    private TextField tfYear;
    
    @FXML 
    private TextField tfPages;

    @FXML 
    private void initialize() throws Exception {
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("year"));
        colPages.setCellValueFactory(new PropertyValueFactory<>("pages"));

        tbBooks.setItems(bookList);
        loadBooks();
    }


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

            //System.out.println("Button clicked! "+id+" "+title+" "+author+" "+year+" "+pages);
            bookList.add(new Book(id, title, author, year, pages));

            /*for(Book book: bookList){
                System.out.println(book.getId()+" "+book.getTitle()+" "+book.getAuthor()+" "+book.getYear()+" "+book.getPages());
            }*/
           //loadBooks();


        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Insert Failed");
            alert.setContentText("Invalid type values.");
            alert.showAndWait();
        }
    }

    private void clearFields() {
        tfId.clear();
        tfTitle.clear();
        tfAuthor.clear();
        tfYear.clear();
        tfPages.clear();
    }

    private void loadBooks() throws Exception{
        clearFields();
        bookList.clear();
        bookList.addAll(repository.getBooks());
        tbBooks.setItems(bookList);
   
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
