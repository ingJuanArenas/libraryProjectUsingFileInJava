package model;

import java.util.List;

public abstract class Person {

    private String name;
    private String role;
    private int id;
    private int limitBooks;
    private List<String> borrowedBooks;

    public abstract void lendBook(String title);
    public abstract void returnBook(String title);
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLimitBooks() {
        return limitBooks;
    }
    public void setLimitBooks(int limitBooks) {
        this.limitBooks = limitBooks;
    }
    public List<String> getBorrowedBooks() {
        return borrowedBooks;
    }
    public void setBorrowedBooks(List<String> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
    
    



}
