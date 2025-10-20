package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.User;
import util.NotFoundException;

public class UserService {

     private List<User> users;

        public UserService() {
        users = new ArrayList<>();

        try (var br = new BufferedReader(new FileReader("users.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                var userData = line.split(",", 7);

                if (userData.length >= 6) {
                    List<String> borrowedBooks = new ArrayList<>();
                    if (userData.length == 7 && !userData[6].isEmpty()) {
                        borrowedBooks = Arrays.asList(userData[6].split("\\|"));
                    }

                    var user = new User(
                        userData[0],                               
                        userData[1],                               
                        userData[2],                               
                        Integer.parseInt(userData[3]),             
                        Integer.parseInt(userData[4]),             
                        Integer.parseInt(userData[5]),             
                        borrowedBooks                              
                    );

                    users.add(user);
                } else {
                    System.out.println("Línea inválida: " + line);
                }
            }

        } catch (Exception e) {
            System.out.println("Error cargando usuarios: " + e.getMessage());
        }
    }
     public void getAllUsers(){
        for (var u : users) {
            System.out.println(u);
        }
    }

    public User getUserById(int id){
        for (var user :  users) {
            if (user.getId() == id) {
                return user;
            }
        }

        throw new NotFoundException("No se ha encontrado el usuario con id: "+ id);
    }

    public void addUser(User user){
        try {
             getUserById(user.getId());
            System.out.println("Ya existe un usuario con ese id");
        } catch (NotFoundException e) {
            users.add(user);
            System.out.println("Usuario agregado exitosamente!!");
        }
           
    
    }

    public void deleteUser(int id){
    
       try {
        var foundUser= getUserById(id);
         users.remove(foundUser);
        System.out.println("Operacion xitosa");
       } catch (NotFoundException e) {
        System.out.println(e.getMessage());
       }
    }


    public void saveUserData(){
        try (var bw = new BufferedWriter(new FileWriter("users.txt"))) {
            for (var user : users) {
                var userToSave= String.format("%s,%s,%s,%d,%d,%d,%s\n",
                    user.getName(),
                    user.getRole(),
                    user.getPassword(),
                    user.getId(),
                    user.getBorrowedBooksQuantity(),
                    user.getLimitBooks(),
                    String.join("|", user.getBorrowedBooks())
                );
                
                bw.write(userToSave);
            
            }
        } catch (Exception e) {
            System.out.println("Error guardando los datos de los usuarios");
        }
    }
}
