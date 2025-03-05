package org.example.WebAnalitycs.Entities.Nodes;

import com.sun.istack.NotNull;
import org.example.WebAnalitycs.Entities.Relations.Relation;
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

    public Person() {

    }

    public Person(Long id) {
        this.id = id;
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

    public Person(Long id, String name, List<Person> friends, List<Relation> relations) {
        this.id = id;
        this.name = name;
        this.friends = friends;
        this.relations = relations;
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

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friends=" + friends +
                ", relations=" + relations +
                '}';
    }
}