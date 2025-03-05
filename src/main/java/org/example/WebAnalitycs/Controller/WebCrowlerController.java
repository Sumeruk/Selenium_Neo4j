package org.example.WebAnalitycs.Controller;

import org.example.WebAnalitycs.Entities.Nodes.Page;
import org.example.WebAnalitycs.Entities.Relations.Link;
import org.example.WebAnalitycs.Service.WebCrowlerService;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WebCrowlerController {

    WebCrowlerService service;

    @Autowired
    public WebCrowlerController(WebCrowlerService service) {
        this.service = service;
    }

    @GetMapping("/getAllPages")
    public String getAllPagesInGraph(Model model){

        List<Page> pages = service.getAllByUrl("http://localhost:8081/");
        System.out.println("DEBUG --- ALL RECORDS " + pages);

        List<Map<String, Object>> nodesOnPage = new ArrayList<>();

        for (Page node: pages) {
            nodesOnPage.add(Map.of("data", Map.of("id", node.getId(), "label", node.getTitle())));
        }

        // Ребра
        List<Map<String, Object>> edgesOnPage = new ArrayList<>();

        for (int i = 0; i < pages.size(); i++) {
            List<Link> linksAtPage = pages.get(i).getLinks();
            for (int j = 0; j < linksAtPage.size(); j++) {
                edgesOnPage.add(Map.of("data", Map.of("id", linksAtPage.get(j),
                        "source", pages.get(i),
                        "target", linksAtPage.get(j), "label", "переход на")));
            }
        }


        model.addAttribute("nodes", nodesOnPage);
        model.addAttribute("edges", edgesOnPage);
        return "pagesGraph";
    }

}
