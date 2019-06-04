package com.example.lb1;

public class User {
    String username;
    String password;
    String firstName;
    String lastName;
    String email;

    public User(String _username, String _password, String _firstName, String _lastName, String _email) {
        this.username = _username;
        this.password = _password;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.email = _email;
    }
    public void SetUsername(String _username){
        this.username = _username;
    }
    public void SetPassword(String _password){
        this.password = _password;
    }
    public void SetFirstName(String _firstName){
        this.firstName = _firstName;
    }
    public void SetLastName(String _lastName){
        this.lastName = _lastName;
    }
    public void SetEmail(String _email){
        this.email = _email;
    }
}
