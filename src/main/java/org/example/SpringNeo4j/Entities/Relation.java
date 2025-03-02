package org.example.SpringNeo4j.Entities;


import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Relation {

    @RelationshipId
    private Long id;

    @TargetNode
    private Person person;

    public Relation(Person person) {
        this.person = person;
    }

    public Relation(Long id, Person person) {
        this.id = id;
        this.person = person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }
}
