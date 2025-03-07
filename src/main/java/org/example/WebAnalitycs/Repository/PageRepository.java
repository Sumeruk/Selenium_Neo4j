package org.example.WebAnalitycs.Repository;

import org.example.WebAnalitycs.Entities.Nodes.Page;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PageRepository extends Neo4jRepository<Page, String> {
}
