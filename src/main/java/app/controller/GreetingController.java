package app.controller;

import app.domain.Client;
import app.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.resources.Messages;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private ClientRepo clietRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Client> clients = clietRepo.findAll();

        model.put("clients", clients);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, Map<String, Object> model) {
        Client client = new Client(name);
        clietRepo.save(client);
        Iterable<Client> clients = clietRepo.findAll();
        model.put("clients", clients);
        return "main";
    }

}
