package service;

import java.util.List;

import model.User;
import util.NotFoundException;

public class LibraryService {
    private static BookService bookService = new BookService();
    private static UserService userService = new UserService();



    public static BookService getBookService() {
        return bookService;
    }

    public static UserService getUserService() {
        return userService;
    }


    public static  void lendBook(User user,String title){
       
        try {
         var bookFound = bookService.getBookByTitle(title);// busco el libro
            if (bookFound.getStatus().equals("Disponible")) {
             //si el usuario tiene cupo 
            if (user.getBorrowedBooksQuantity()<user.getLimitBooks()) {
                bookFound.setStatus("Prestado");
                //traigoo la lista
                var borredBooks= user.getBorrowedBooks();
                borredBooks.add(title);
                // modifico
                user.setBorrowedBooks(borredBooks);
                // traigo la cantidad
                var quantity= user.getBorrowedBooksQuantity()+1;
                // modifico
                user.setBorrowedBooksQuantity(quantity);

                System.out.println("Prestamo exitoso!!!");
            }else{
                System.out.println("Limite de libros alcanzado");
           }
            }else{
            System.out.println("El libro no está disponible");
           }
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void returnBook(User user, String title){
        try {
            var bookFound= bookService.getBookByTitle(title);
        var isBorrowedByUser = isBorrowedByUser(user, title);

            if (bookFound.getStatus().equals("Prestado") ) {
               if (isBorrowedByUser) {
                 bookFound.setStatus("Disponible");
                var quantity= user.getBorrowedBooksQuantity() -1 ;
                user.setBorrowedBooksQuantity(quantity);

                System.out.println("Devolucion exitosa");
               }else{
                System.out.println("El libro no fue Prestado por el usuario");
               }
            }else{
                System.out.println( " ERROR : El estado del libro es " + bookFound.getStatus() );
            }
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public static boolean isBorrowedByUser(User user, String title){
        var borrowedBooks = user.getBorrowedBooks();
        if (borrowedBooks.contains(title)) {
            return true;
        }
        return false;

    }


}
