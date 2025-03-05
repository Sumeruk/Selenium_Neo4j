package org.example.WebAnalitycs.Service;

import org.example.WebAnalitycs.DTO.ResultOfShortestPath;
import org.example.WebAnalitycs.Entities.Nodes.Person;
import org.example.WebAnalitycs.Entities.Relations.Relation;
import org.example.WebAnalitycs.Repository.PersonRepository;
import org.example.WebAnalitycs.Repository.RelRepository;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Path;
import org.neo4j.driver.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RelRepository relationRepository;

    public void createPersonAndFriends() {
        Person alice = new Person(1L, "Alice");
        Person bob = new Person(2L, "Bob");
        Person charlie = new Person(3L, "Charlie");

        // Добавляем друзей (ненаправленные связи)
        alice.addFriendship(bob);
        alice.addFriendship(charlie);

        Relation toBob = new Relation(bob);
        Relation toCharlie = new Relation(charlie);
        alice.addRelation(toBob);
        alice.addRelation(toCharlie);

        personRepository.save(alice);

    }

    public ResultOfShortestPath getShortestPath(String startName, String endName){

        Iterable<PathValue> path = personRepository.findShortestPath(startName, endName);
        System.out.println("DEBUG--- just path sout " + path);

        Path onePath = path.iterator().next().asPath();

        Iterable<Node> nodes = onePath.nodes();
        Iterable<Relationship> relationships = onePath.relationships();

        return new ResultOfShortestPath(nodes, relationships);
    }

    @Transactional
    public List<Person> getAll(){
        return personRepository.findAll();
    }


}