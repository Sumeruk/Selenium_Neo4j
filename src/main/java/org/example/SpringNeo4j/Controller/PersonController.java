package org.example.SpringNeo4j.Controller;

import org.example.SpringNeo4j.Entities.Person;
import org.example.SpringNeo4j.Service.PersonService;
import org.neo4j.driver.internal.value.PathValue;
import org.neo4j.driver.types.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        Iterable<Node> nodes = personService.getShortestPath("Alice", "Charlie");

//        Iterable<Node> nodes = personService.getShortestPath("Bob", "Charlie");
//        List<Node> nodesInList = new ArrayList<>();
        List<Map<String, Object>> nodesOnPage = new ArrayList<>();

        for (Node node: nodes) {
//            nodesInList.add(node);
            nodesOnPage.add(Map.of("data", Map.of("id", node.asMap().get("name"), "label", node.asMap().get("name"))));
        }

        //exmple of add data to html
//        nodesOnPage.add(Map.of("data", Map.of("id", "a", "label", "Node A")));
//        nodesOnPage.add(Map.of("data", Map.of("id", "b", "label", "Node B")));
//        nodesOnPage.add(Map.of("data", Map.of("id", "c", "label", "Node C")));

        // Ребра
        List<Map<String, Object>> edgesOnPage = new ArrayList<>();

//        for (Node node: nodes) {
////            nodesInList.add(node);
//            edgesOnPage.add(Map.of("data", Map.of("id", node.elementId(), "label", node.asMap().get("name"))));
//        }

        edgesOnPage.add(Map.of("data", Map.of("id", "ab", "source", "Alice", "target", "Charlie", "label", "Edge AB")));
//        edgesOnPage.add(Map.of("data", Map.of("id", "bc", "source", "Alice", "target", "Bob", "label", "Edge BC")));

        model.addAttribute("nodes", nodesOnPage);
        model.addAttribute("edges", edgesOnPage);

        return "index";
    }

    @GetMapping("/getSmth")
    public String getSmth(Model model){
        System.out.println(personService.getAll());
        return "all";
    }
}
