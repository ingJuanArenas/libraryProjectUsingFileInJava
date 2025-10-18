package model;

import java.util.ArrayList;

public class Admin extends Person {

    private int  borrowedBooksQuantity;
    Admin(String name, int id){
        setName(name);
        setId(id);
        setRole("Admin");
        setLimitBooks(20);
        setBorrowedBooks(new ArrayList<>());
        this.borrowedBooksQuantity =0;
    }
      @Override
    public void lendBook(String title) {
        if (borrowedBooksQuantity < getLimitBooks()) {
            var borrowedBooks= getBorrowedBooks();
            borrowedBooks.add(title);
            setBorrowedBooks(borrowedBooks);
        }else{
            System.out.println("Limite de libros alcanzado");
        }
    }

    @Override
    public void returnBook(String title) {
        var borrowedBooks = getBorrowedBooks();
        for (var string : borrowedBooks) {
            if (string.equals(title)) {
                borrowedBooksQuantity--;
                System.out.printf("Gracias por retornar el libro, tienes %d libros por devolver" , borrowedBooksQuantity);
                break;
            }
        }
    }
    
}
