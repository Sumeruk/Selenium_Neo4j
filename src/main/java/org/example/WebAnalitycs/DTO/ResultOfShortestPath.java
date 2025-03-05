package org.example.WebAnalitycs.DTO;

import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Relationship;


public class ResultOfShortestPath {
    private Iterable<Node> nodes;
    private Iterable<Relationship> relationships;

    public ResultOfShortestPath(Iterable<Node> nodes, Iterable<Relationship> relationships) {
        this.nodes = nodes;
        this.relationships = relationships;
    }

    public Iterable<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Iterable<Node> nodes) {
        this.nodes = nodes;
    }

    public Iterable<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(Iterable<Relationship> relationships) {
        this.relationships = relationships;
    }
}
