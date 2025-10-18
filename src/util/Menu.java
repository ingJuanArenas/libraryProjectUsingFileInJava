package util;

import java.util.Scanner;

import model.Book;
import model.User;


public class Menu {
    public static Scanner sc = new Scanner(System.in);
    private static int op;
    
    public static int showMainMenu (){
        System.err.println("""
==== Biblioteca ====
1. Entrar como Admin
2. Entrar como User
                """);
        System.out.println("Ingrese opcion: ");
        op= sc.nextInt();
    
        return op;


    }

    public static int showAdminMenu(){
        System.out.println("""
=== Bienvenido al portal de Admin ===
1. Manejo de Usuarios
2. Manejo de libros. 
                """);

        return sc.nextInt();

    }


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

    public static int getId(){
        System.out.println("Ingrese el id: ");
        return sc.nextInt();
    }

    public static User getUserToRegister(){
        sc.nextLine();
        System.out.print("Ingrese el nombre: ");
        var name =sc.nextLine();
        System.out.println("Ingrese el ID: ");
        var id = sc.nextInt();

        return new User(name, id);

    }

    


}
