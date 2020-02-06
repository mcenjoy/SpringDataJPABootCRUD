package com.demo.services;

import com.demo.model.Person;
import com.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by mcenjoy
 * on 05/02/2020
 */
@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() throws InterruptedException {
        Thread.sleep(300);
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }

    @Override
    public void listAllPerson() {
        personRepository.findAll().forEach(elem -> System.out.println(elem.getId()));
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void removeById(long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));
        personRepository.delete(person);
    }

    @Override
    public List<Person> findPersonByName(String name) {
        return personRepository.findPersonByName(name);
    }

    @Override
    public List<Person> findPersonByEmail(String email) {
        return personRepository.findPersonByEmail(email);
    }

    @Override
    public List<Person> findPersonByNameAndEmail(String name, String email) {
        return personRepository.findPersonByNameAndEmail(name, email);
    }

    @Override
    public Optional<Person> findById(long id) throws InterruptedException {
        findAll();
        return personRepository.findById(id);
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}