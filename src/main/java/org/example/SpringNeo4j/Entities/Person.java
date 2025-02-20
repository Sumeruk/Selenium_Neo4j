package org.example.SpringNeo4j.Entities;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Person {

    @Id
    private Long id;
    @NotNull
    private String name;

//    @Relationship(type = "FRIEND_OF", direction = Relationship.Direction.OUTGOING)
//    private List<Person> friends;


    // Конструкторы, геттеры и сеттеры

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
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