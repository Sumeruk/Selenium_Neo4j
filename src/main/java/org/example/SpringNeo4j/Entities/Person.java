package org.example.SpringNeo4j.Entities;

import com.sun.istack.NotNull;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Property
    private String name;

    @Relationship(type = "FRIEND_OF", direction = Relationship.Direction.OUTGOING)
    private List<Person> friends = new ArrayList<>();

    @Relationship(type = "FRIENDS_OF2", direction = Relationship.Direction.OUTGOING)
    private List<Relation> relations = new ArrayList<>();

    public void addFriendship(Person person) {
        this.friends.add(person);
    }

    public void addRelation(Relation relation){
        this.relations.add(relation);
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(Long id, String name, List<Person> person) {
        this.id = id;
        this.name = name;
        this.friends = person;
    }

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<Person> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(Set<Person> friends) {
//        this.friends = friends;
//    }
}