package org.example.SpringNeo4j.Repository;

import org.example.SpringNeo4j.Entities.Relation;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface RelRepository extends Neo4jRepository<Relation, Long> {

    @Query("MATCH ()-[r:FRIENDS_OF2]->()\n" +
            "RETURN r;")
    List<RelationshipValue> findAlldd();
}
