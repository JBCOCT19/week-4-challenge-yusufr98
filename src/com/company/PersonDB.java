package com.company;

import java.util.ArrayList;

public class PersonDB{
    private ArrayList<Person> people;

    public PersonDB() {
        people = new ArrayList<>();
    }

    public PersonDB(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public void add (Person p){
        people.add(p);
    }
}
