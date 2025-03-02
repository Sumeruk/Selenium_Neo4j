package org.example.SpringNeo4j.Service;

import org.example.SpringNeo4j.Entities.Person;
import org.example.SpringNeo4j.Entities.Relation;
import org.example.SpringNeo4j.Repository.PersonRepository;
import org.example.SpringNeo4j.Repository.RelRepository;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Path;
import org.neo4j.driver.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public Iterable<Node> getShortestPath(String startName, String endName){
//        System.out.println(personRepository.findShortestPath(startName, endName));

        Iterable<PathValue> path = personRepository.findShortestPath(startName, endName);
        System.out.println("DEBUG--- just path sout " + path);

        List<RelationshipValue> relationshipValues = relationRepository.findAlldd();
        System.out.println("DEBUG--- all relations " + relationshipValues);

        Path onePath = path.iterator().next().asPath();

        Iterable<Node> nodes = onePath.nodes();
        System.out.println(nodes);
//        System.out.println(nodes.iterator().next().id()); //почему-то deprecated
        for (Node node: nodes) {
            System.out.println("DEBUG---nodes " + node.asMap());
        }


        for (RelationshipValue relationship: relationshipValues) {
            System.out.println("DEBUG---relationship " + relationship.asRelationship().endNodeElementId());
        }



        return nodes;
    }

    @Transactional
    public List<Person> getAll(){
        return personRepository.findAll();
    }


//    @Autowired
//    private Neo4jTemplate neo4jTemplate;
//
//    public String getRelationshipTypeById(Long relationshipId) {
//        String query = "MATCH ()-[r]->() WHERE id(r) = $relationshipId RETURN type(r)";
//        String response = neo4jTemplate.findOne(query, Map.of("relationshipId", relationshipId), String.class)
//                .orElseThrow(() -> new RuntimeException("Relationship not found"));
//
//        System.out.println("DEBUG---response " + response);
//        return response;
//    }
}