package com.company;

public class Faculty extends Person{

    public Faculty(String name, long id, String userEmail, String userPassword) {
        super(name, id, userEmail, userPassword);
    }

    public Faculty(String name, long id) {
        super(name, id);
    }
    @Override
    public String toString(){
        return ("Faculty ID: " + this.getId() + "\n" +
                "Faculty Name: " + this.getName()+ "\n");
    }
    public Faculty() {
    }
}
