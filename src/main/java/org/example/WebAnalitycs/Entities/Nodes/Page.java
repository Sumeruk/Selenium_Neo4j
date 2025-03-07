package org.example.WebAnalitycs.Entities.Nodes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.WebAnalitycs.Entities.Relations.Link;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@Node
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {

    @Id
    String url;
    String title;

    @Relationship(type = "TRANSITION_TO", direction = Relationship.Direction.OUTGOING)
    List<Link> links = new ArrayList<>();

    public void addOneLink(Link link){
        links.add(link);
    }


}
