package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import util.NotFoundException;

public class BookService {
    private List<Book> books;
    public BookService(){

        books = new ArrayList<>();
        
        try (var br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line= br.readLine()) != null) {
                var bookData= line.split(",");
                var book= new Book(
                    bookData[0], bookData[1], bookData[2],
                    bookData[3], bookData[4]
                );
                books.add(book);
            }
        } catch (Exception e) {
            System.out.println("Error: "+ e );
        }
    }

    public void getAll(){
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void getAllAvaliable(){
        for (var book : books) {
            if (book.getStatus().equals("Prestado")) {
                continue;
            }
            System.out.println(book);
        }
    }
    public Book getBookByIsbn(String isbn){
        for (var book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
       throw new NotFoundException("No se encontro el libro con isbn: " + isbn);
    }

    public Book getBookByTitle(String title){
        for (var book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
       throw new NotFoundException("No se encontro el libro con titulo: " + title);
    }

    public void addBook(Book book){
       
        try {
            getBookByIsbn(book.getIsbn());
        } catch (Exception e) {
            books.add(book);
            System.out.println("Operacion exitosa");
        }
                
        
    }
    public void removeBook(String isbn){
       
       try {
         var  bookToDelete = getBookByIsbn(isbn);
         books.remove(bookToDelete);
         System.out.println("Operacion exitosa");
       } catch (Exception e) {
        System.out.println(e.getMessage());
       }
    
    }
        
     public void saveBooksData(){
        try (FileWriter writer = new FileWriter("books.txt")) {
            for (var book : books) {
                writer.write(
                    String.format("%s,%s,%s,%s,%s\n",
                    book.getIsbn(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getStatus()
                    )
                );
            }
        } catch (Exception e) {
            System.out.println("Error guardando los datos de los usuarios");
        }
    }
}
