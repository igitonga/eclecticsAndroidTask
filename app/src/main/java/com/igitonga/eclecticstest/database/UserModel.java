package com.igitonga.eclecticstest.database;

public class UserModel {

    private int id;
    private String username;
    private String password;

//    constructor

    public UserModel(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

//    toString is neccessary to print content

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


//    getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
