package service;

import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookService {
    private List<Book> books;
    public BookService(){
        this.books = new ArrayList<>();
    }

    public void getAll(){
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public Book getBookByIsbn(String isbn){
        for (var book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
       return null;
    }

    public void addBook(Book book){
        var foundBook = getBookByIsbn(book.getIsbn());
        if (foundBook != null) {
            System.out.println("Ya se encontró un libro con ese isbn");
        }else{
            books.add(book);
            System.out.println("Operacion exitosa");
        }
    }
    public void removeBook(String isbn){
        var  bookToDelete = getBookByIsbn(isbn);
       try {
         books.remove(bookToDelete);
        System.out.println("Operacion exitosa");
       } catch (Exception e) {
        System.out.println("Un error al eliminar: " + e);
       }
    }
        
}
