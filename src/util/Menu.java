package util;

import java.util.Scanner;

import model.Book;
import model.User;


public class Menu {
    public static Scanner sc = new Scanner(System.in);
    
        
    public static Book getBookToAddInfo(){
        sc.nextLine();
        System.out.print("Ingrese el isbn: ");
        var isbn =sc.nextLine();
        System.out.println("Ingrese el titulo: ");
        var title = sc.nextLine();
        System.out.println("Ingrese el autor: ");
        var author = sc.nextLine();
        System.out.println("Ingrese el genero: ");
        var genre = sc.nextLine();

        return new Book(isbn, title, author, genre);

    }

    public static String getIsbn(){
        System.out.println("Ingrese el isbn: ");
        return sc.nextLine();
    }
    public static String getTitle(){
        System.out.println("Ingrese el Titulo: ");
        return sc.nextLine();
    }

    public static int getId(){
        System.out.println("Ingrese el id: ");
        return sc.nextInt();
    }

    public static String getPassWord(){
        sc.nextLine();
        System.out.println("Ingrese la contraseña: ");
        return sc.nextLine();
    }

    public static User getUserToRegister(){
        sc.nextLine();
        System.out.print("Ingrese el nombre: ");
        var name =sc.nextLine();
        var id = getId();
        var password = getPassWord();

        return new User(name, id, password);

    }

    


}
