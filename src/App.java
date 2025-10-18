
import java.util.Scanner;

import util.AdminMenu;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean salir = false;

        do {
            try {
                AdminMenu.showAdminMenu();
                var op = sc.nextInt();
                AdminMenu.executeAdmin(op);
            } catch (Exception e) {
                salir = true;
                System.out.println("ERROR : " + e);
            }
        } while (salir != true);
        
    }

   
}


