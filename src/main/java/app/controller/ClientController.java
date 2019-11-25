package app.controller;

import app.domain.Client;
import app.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ClientController {

    @Autowired
    private ClientRepo clientRepo;

    @GetMapping("/addclient")
    public String addClient(Map<String, Object> model) {
        Iterable<Client> clients = clientRepo.findAll();
        model.put("clients", clients);
        return "addclient";
    }

    @PostMapping("/addclient")
    public String addClient(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String midname,
            Map<String, Object> model) {
        Client newClient = new Client(firstname, lastname, midname);
        clientRepo.save(newClient);
        Iterable<Client> clients = clientRepo.findAll();
        model.put("clients", clients);
        return "clients";
    }

}
