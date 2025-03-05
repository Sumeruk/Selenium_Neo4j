package org.example.WebAnalitycs.Entities.Relations;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.WebAnalitycs.Entities.Nodes.Person;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RelationshipProperties
public class Relation {

    @RelationshipId
    private Long id;

    @TargetNode
    private Person person;

    public Relation(Person person) {
        this.person = person;
    }
}
