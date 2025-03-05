package org.example.WebAnalitycs.Entities.Relations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.WebAnalitycs.Entities.Nodes.Page;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Data
@AllArgsConstructor
public class Link {

    @RelationshipId
    private Long id;

    @TargetNode
    private Page nextPage;

}
