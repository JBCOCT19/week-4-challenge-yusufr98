package com.company;

public abstract class Person {
    private String name;
    private long id;
    private String userEmail;
    private String userPassword;

    public Person() {
    }

    public Person(String name, long id, String userEmail, String userPassword) {
        this.name = name;
        this.id = id;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public Person(String name, long id) {
        this.name = name;
        this.id = id;
        this.userEmail = name + "@gmail.com";
        this.userPassword = "password";
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
