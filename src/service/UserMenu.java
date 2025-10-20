package service;

import model.User;
import util.Menu;

public class UserMenu {
    public static void showUserMenu(){
        System.out.println("""
        1. Mostrar Biblioteca
        2. Consultar libro
        3. Prestar libro
        4. Devolver libro
        0. salir
                """);

        System.out.print("Ingrese la opcion: ");
    }


    public static void executeUserMenu(int op, User userLogged){
        try {
            switch (op) {
            case 1:
                LibraryService.getBookService().getAllAvaliable();
                break;
            case 2: 
            var isbn= Menu.getIsbn();
            var bookFound = LibraryService.getBookService().getBookByIsbn(isbn);
            System.out.println((bookFound == null) ? "No encontrado" : bookFound);
            break;
            case 3: 
                var title = Menu.getTitle();
                LibraryService.lendBook(userLogged, title);
                break;
            case 4:
                var bookToReturn = Menu.getTitle();
                LibraryService.returnBook(userLogged, bookToReturn);
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    
    }
}
