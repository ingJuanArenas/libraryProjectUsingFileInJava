package service;

import util.Menu;

public class AdminService {

    public static LibraryService lService= new LibraryService();

    public static void showAdminMenu(){
        System.out.println("""
        1. Registrar Usuario
        2. Borrar Usuario
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

    public static void executeAdmin(int op){
        switch (op) {
            case 1:
                var user = Menu.getUserToRegister();
                lService.getUserService().addUser(user);
                break;
            case 2: 
                var idToDelete= Menu.getId();
                lService.getUserService().deleteUser(idToDelete);
                break;
            case 3: 
                var idToSearch = Menu.getId();
                var userFound= lService.getUserService().getUserById(idToSearch);
                System.out.println((userFound == null ? "No se encontró" : userFound));
                break;
            case 4:
                var book= Menu.getBookToAddInfo();
                lService.getBookService().addBook(book);
                break;
            case 5:
                var isbn = Menu.getIsbn();
                var bookFound = lService.getBookService().getBookByIsbn(isbn);
                System.out.println((bookFound == null) ? "No se encontró" : bookFound);
                break;
            case 6:
                lService.getBookService().getAll();
                break;

            case 9:
                var isbnToDelete = Menu.getIsbn();
                lService.getBookService().removeBook(isbnToDelete);

            default:
            System.out.println("Opcion invalida");
                break;
        }
    }


}
