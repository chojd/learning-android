package com.ofashion.annotationenum;

public class Entrance {

    public Person getPerson() {
        Person person = new Person();
        person.setGender(Person.Gender.MALE);
        return person;
    }
}
