package it.repositoryImp;

import it.model.Person;
import it.repository.PersonRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonRepositoryImpl implements PersonRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    public void update(Person person, int id) {
        if (person.getAge() < 100) {
            Session session = sessionFactory.getCurrentSession();
            Person person1 = session.get(Person.class, id);
            person1.setName(person.getName());
            person1.setAge(person.getAge());
            session.merge(person1);
        } else {
            throw new RuntimeException("age big");
        }
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.delete(person);
    }

    public List<Person> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Person p", Person.class).getResultList();
    }


    public Person findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }
}