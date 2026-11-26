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


        tbBooks.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, selectedBook) -> {
        if (selectedBook != null) {
                tfId.setText(String.valueOf(selectedBook.getId()));
                tfTitle.setText(selectedBook.getTitle());
                tfAuthor.setText(selectedBook.getAuthor());
                tfYear.setText(String.valueOf(selectedBook.getYear()));
                tfPages.setText(String.valueOf(selectedBook.getPages()));
            }
        });



        loadBooks();
    }


    @FXML
    private void handleBtnAction(javafx.event.ActionEvent event) {  

       // System.out.println("Button clicked!");
        Object source = event.getSource();

        if(source.toString() == "Insertar"){
            try {
                insertBook();
            } catch (Exception e) {
        
                e.printStackTrace();
            }
        }

        if(source.toString().contains("Actualizar")){
           try {
                updateBook();
            } catch (Exception e) {
        
                e.printStackTrace();
            }

        }

        if(source.toString().contains("Eliminar")){
           try {
                deleteBook();
            } catch (Exception e) {
        
                e.printStackTrace();
            }

        }
    }


        private void updateBook() throws Exception{

        try {
            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String author = tfAuthor.getText();
            int year = Integer.parseInt(tfYear.getText());
            int pages = Integer.parseInt(tfPages.getText());


            Book modifiedBook = new Book(id, title, author, year, pages);
            repository.updateBook(modifiedBook);
            bookList.clear();
            bookList.addAll(repository.getBooks());


        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("update Failed");
            alert.setContentText("An error happend.");
            alert.showAndWait();
        }
    }

    private void insertBook() throws Exception{

        try {
            //int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String author = tfAuthor.getText();
            int year = Integer.parseInt(tfYear.getText());
            int pages = Integer.parseInt(tfPages.getText());

            //System.out.println("Button clicked! "+id+" "+title+" "+author+" "+year+" "+pages);
            //bookList.add(new Book(id, title, author, year, pages));

            Book newBook = new Book(title, author, year, pages);
            repository.insertBook(newBook);
            bookList.clear();
            bookList.addAll(repository.getBooks());
            
            

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

        private void deleteBook() throws Exception{

        try {
            int id = Integer.parseInt(tfId.getText());
            String title = tfTitle.getText();
            String author = tfAuthor.getText();
            int year = Integer.parseInt(tfYear.getText());
            int pages = Integer.parseInt(tfPages.getText());

            Book newBook = new Book(id, title, author, year, pages);
            repository.deleteBook(newBook);
            bookList.clear();
            bookList.addAll(repository.getBooks());

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("delete Failed");
            alert.setContentText("delete failed.");
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
