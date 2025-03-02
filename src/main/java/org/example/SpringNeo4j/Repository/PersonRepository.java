package org.example.SpringNeo4j.Repository;

import org.example.SpringNeo4j.Entities.Person;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("MATCH (start:Person {name: $startName}), (end:Person {name: $endName}), " +
            "p = shortestPath((start)-[*..10]-(end)) " +
            "RETURN p")
    Iterable<PathValue> findShortestPath(@Param("startName") String startName, @Param("endName") String endName);

}
