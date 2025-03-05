package org.example.WebAnalitycs.Repository;

import org.example.WebAnalitycs.Entities.Relations.Relation;
import org.neo4j.driver.internal.value.ListValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelRepository extends Neo4jRepository<Relation, Long> {

    @Query("MATCH ()-[r:FRIENDS_OF2]->()\n" +
            "RETURN r;")
    List<RelationshipValue> findAlldd();

    @Query("MATCH (start:Person {name: $startName}), (end:Person {name: $endName}), \n" +
            "p = shortestPath((start)-[*..10]-(end))\n" +
            "RETURN RELATIONSHIPS(p)")
    List<ListValue> findRelationsInPath(@Param("startName") String startName, @Param("endName") String endName);
}
