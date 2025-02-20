package org.example.SpringNeo4j.Service;

import org.example.SpringNeo4j.Entities.Person;
import org.example.SpringNeo4j.Repository.PersonRepository;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.types.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void createPersonAndFriends() {
        Person alice = new Person(1L, "Alice");
        Person bob = new Person(2L, "Bob");
        Person charlie = new Person(3L, "Charlie");

        // Добавляем друзей (ненаправленные связи)
//        alice.addFriend(bob);
//        alice.addFriend(charlie);

        // Сохраняем узлы и связи
        personRepository.save(alice);
    }

    public Iterable<org.neo4j.driver.internal.value.PathValue> getShortestPath(String startName, String endName){
//        System.out.println(personRepository.findShortestPath(startName, endName));

        Iterable<PathValue> path = personRepository.findShortestPath(startName, endName);

        System.out.println(path);
        return path;
    }

    @Transactional
    public List<Person> getAll(){
        return personRepository.findAll();
    }
}