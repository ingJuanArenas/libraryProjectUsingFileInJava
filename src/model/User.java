package model;

import java.util.ArrayList;
import java.util.List;

public class User{
    private String name;
    private String role;
    private String password;
    private int id;
    private int borrowedBooksQuantity;
    private int limitBooks;
    private List<String> borrowedBooks;

    
        

    
    public User(String name, String role, String password, int id, int borrowedBooksQuantity, int limitBooks,
        List<String> borrowedBooks) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.id = id;
        this.borrowedBooksQuantity = borrowedBooksQuantity;
        this.limitBooks = limitBooks;
        this.borrowedBooks = borrowedBooks;
    }

    public User(String name, int id, String password) {
        this.name= name;
        this.role = "User";
        this.id = id;
        this.password = password;
        this.borrowedBooksQuantity = 0;
        this.limitBooks = (role.equals("User"))? 4: 10;
        this.borrowedBooks = new ArrayList<>();
    }

     public User(String name,String role ,int id, String password) {
        this.name= name;
        this.role = role;
        this.id = id;
        this.password = password;
        this.borrowedBooksQuantity = 0;
        this.limitBooks = (role.equals("User"))? 4: 10;
        this.borrowedBooks = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
    public int getId() {
        return id;
    }
    public int getBorrowedBooksQuantity() {
        return borrowedBooksQuantity;
    }

    public int getLimitBooks() {
        return limitBooks;
    }
    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }


    public void setBorrowedBooksQuantity(int borrowedBooksQuantity) {
        this.borrowedBooksQuantity = borrowedBooksQuantity;
    }

    public void setBorrowedBooks(List<String> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    


    public void setRole(String role) {
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", role=" + role + ", password=" + password + ", id=" + id
                + ", borrowedBooksQuantity=" + borrowedBooksQuantity + ", limitBooks=" + limitBooks + ", borrowedBooks="
                + borrowedBooks + "]";
    }

    
    
}
