package org.example.WebAnalitycs.Repository;

import org.example.WebAnalitycs.Entities.Relations.Link;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LinkRepository extends Neo4jRepository<Link, Long> {
}
