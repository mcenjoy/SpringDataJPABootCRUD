package com.demo.services;

import com.demo.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findAll() throws InterruptedException;
    Person addPerson(Person person);
    void updatePerson (Person person);
    void removeById(long id);
    void listAllPerson();

    List<Person> findPersonByName(String name);
    List<Person> findPersonByEmail(String email);
    List<Person> findPersonByNameAndEmail(String name, String email);
    Optional<Person> findById(long id) throws InterruptedException;
}
