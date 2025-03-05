package org.example.WebAnalitycs.Controller;

import org.example.WebAnalitycs.DTO.ResultOfShortestPath;
import org.example.WebAnalitycs.Service.PersonService;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/create")
    public String create() {
        personService.createPersonAndFriends();
        return "all";
    }

    @GetMapping("/getPath")
    public String getPath(Model model){
        ResultOfShortestPath path = personService.getShortestPath("Bob", "Charlie");

        List<Map<String, Object>> nodesOnPage = new ArrayList<>();

        for (Node node: path.getNodes()) {
            nodesOnPage.add(Map.of("data", Map.of("id", node.elementId(), "label", node.asMap().get("name"))));
        }

        // Ребра
        List<Map<String, Object>> edgesOnPage = new ArrayList<>();

        for (Relationship relationship: path.getRelationships()) {
            edgesOnPage.add(Map.of("data", Map.of("id", relationship.elementId(),
                    "source", relationship.startNodeElementId(),
                    "target", relationship.endNodeElementId(), "label", relationship.type())));
        }


        model.addAttribute("nodes", nodesOnPage);
        model.addAttribute("edges", edgesOnPage);

        return "index";
    }

    @GetMapping("/getSmth")
    public String getSmth(Model model){
        System.out.println("DEBUG --- ALL RECORDS " + personService.getAll());

        return "all";
    }
}
