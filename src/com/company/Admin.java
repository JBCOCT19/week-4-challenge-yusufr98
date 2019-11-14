package com.company;

public class Admin extends Person {
    public Admin() {
    }

    public Admin(String name, long id) {
        super(name, id);
    }

    public Admin(String name, long id, String userEmail, String userPassword){
        super(name, id, userEmail, userPassword);
    }
}
