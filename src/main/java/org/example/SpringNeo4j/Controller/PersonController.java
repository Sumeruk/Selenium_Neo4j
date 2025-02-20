package org.example.SpringNeo4j.Controller;

import org.example.SpringNeo4j.Entities.Person;
import org.example.SpringNeo4j.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
//        System.out.println(personService.getShortestPath("Alice", "Charlie"));

        String path = personService.getShortestPath("Alice", "Charlie").toString();
        model.addAttribute("elements", path);
        return "index";
    }

    @GetMapping("/getSmth")
    public String getSmth(Model model){
        System.out.println(personService.getAll());
        return "all";
    }
}
