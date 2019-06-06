package com.example.lb1;

public class UserService {

    private static UserService instance;

    public static synchronized UserService getInstance () {
        if (UserService.instance == null) {
            UserService.instance = new UserService ();
        }
        return UserService.instance;
    }

    public void getAllUsers(){

    }

    public void getUserById(int id){

    }

    public void deleteUserById(int id){

    }

    public void updateUser(int id){

    }

    public void addUser(User user){

    }

    public void countUsers(){

    }
}
