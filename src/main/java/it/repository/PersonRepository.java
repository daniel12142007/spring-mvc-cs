package it.repository;

import it.model.Person;

import java.util.List;

public interface PersonRepository {
    void save(Person person);

    void update(Person person, int id);

    void delete(int id);

    List<Person> findAll();

    Person findById(int id);

}