package service;

import model.User;
import util.Menu;

public class AdminService {
    public static void showAdminMenu(){
        System.out.println("""
        1. Guardar informacion Usuario
        2. Guardar informacion libro
        3. Consultar Usuario
        4. Agregar libro
        5. Consultar libro
        6. Mostrar Biblioteca
        7. Prestar libro
        8. Devolver libro
        9. Eliminar libro
        0. salir
                """);

        System.out.print("Ingrese la opcion: ");
    }

    public static void executeAdmin(int op, User userLogged){
       try {
         switch (op) {
            case 1:
                LibraryService.getUserService().saveUserData();
                break;
            case 2: 
                LibraryService.getBookService().saveBooksData();
                break;
            case 3: 
                var idToSearch = Menu.getId();
                var userFound= LibraryService.getUserService().getUserById(idToSearch);
                System.out.println((userFound == null ? "No se encontró" : userFound));
                break;
            case 4:
                var book= Menu.getBookToAddInfo();
                LibraryService.getBookService().addBook(book);
                break;
            case 5:
                var isbn = Menu.getIsbn();
                var bookFound = LibraryService.getBookService().getBookByIsbn(isbn);
                System.out.println((bookFound == null) ? "No se encontró" : bookFound);
                break;
            case 6:
                LibraryService.getBookService().getAll();
                break;
            case 7:
                var title= Menu.getTitle();
                LibraryService.lendBook(userLogged, title);
                break;
            case 8:
                var bookToReturn= Menu.getTitle();
                LibraryService.returnBook(userLogged,bookToReturn);
                break;
            case 9:
                var isbnToDelete = Menu.getIsbn();
                LibraryService.getBookService().removeBook(isbnToDelete);
                break;
            case 0: 
                System.out.println("Saliendo ...");
            default:
                System.out.println("Opcion invalida");
                break;
        }
       } catch (Exception e) {
        System.out.println(e.getMessage());
       }
    }


}
