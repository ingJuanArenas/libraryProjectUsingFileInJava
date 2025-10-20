
import java.util.Scanner;
import java.util.InputMismatchException;
import model.User;
import service.AdminService;
import service.LibraryService;
import service.UserMenu;
import util.Menu;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean salir = false;

do {
    try {
        System.out.println("""
            === Bienvenido a la Biblioteca ====
            1. Ingresar
            2. Crear Cuenta
            0. Salir
        """);

        System.out.print("Elige una opción: ");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                var id = Menu.getId();
                var password = Menu.getPassWord();
                login(id, password);
                break;
            case 2:
                var userToRegister = Menu.getUserToRegister();
                LibraryService.getUserService().addUser(userToRegister);
                break;
            case 0:
                salir = true;
                break; 
            default:
                System.out.println("Opción inválida");
                break;
        }

    } catch (InputMismatchException e) {
        System.out.println("Dato inválido, debes ingresar un número.");
        sc.nextLine(); 
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

} while (!salir);

    }
    public static void login(int id, String psw){
          try {
            var userFound = LibraryService.getUserService().getUserById(id);
            if (userFound.getPassword().equals(psw)) {
                System.out.println("Login exitoso");
                if (userFound.getRole().equals("Admin")) {
                    executeAdminMenu(userFound);
                }else{
                    executeUserMenu(userFound);
                }
            }else{
                System.out.println("contraseña incorrecta");
            }
          } catch (Exception e) {
           System.out.println(e.getMessage());
          }
         
    }
   

    public static void executeAdminMenu(User user){
        int op = 1;
        do {
            AdminService.showAdminMenu();
            op= sc.nextInt();
             AdminService.executeAdmin(op, user);
        } while (op != 0);
    }

    public static void executeUserMenu(User user){
        int op = 1;
        do {
            UserMenu.showUserMenu();
            op= sc.nextInt();
             UserMenu.executeUserMenu(op, user);
        } while (op != 0);
    }

}


