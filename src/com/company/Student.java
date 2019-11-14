package com.company;

public class Student extends Person{
    public Student() {
    }

    public Student(String name, long id) {
        super(name, id);
    }
    @Override
    public String toString(){
        return ("Student ID: " + this.getId() + "\n" +
                "Student Name: " + this.getName()+ "\n");
    }

    public Student(String name, long id, String userEmail, String userPassword) {
        super(name, id, userEmail, userPassword);
    }
}
