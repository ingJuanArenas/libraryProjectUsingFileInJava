package service;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserService {

     private List<User> users;

     public UserService(){
        this.users= new ArrayList<>();
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

        return null;
    }

    public void addUser(User user){
        var foundUser= getUserById(user.getId());
        if (foundUser == null) {
            users.add(user);
        }else{
            System.out.println("Id ya registrado");
        }
    }

    public void deleteUser(int id){
        var foundUser= getUserById(id);
        if (foundUser != null) {
            users.remove(foundUser);
            System.out.println("Operacion xitosa");
        }else{
            System.out.println("No se ha encontrado el id");
        }
    }

}
