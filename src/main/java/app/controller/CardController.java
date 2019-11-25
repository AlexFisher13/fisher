package app.controller;

import app.domain.Card;
import app.repos.CardRepo;
import app.repos.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CardController {

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private CardRepo cardRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Card> cards = cardRepo.findAll();
        model.put("cards", cards);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String number,
                      @RequestParam String holder,
                      @RequestParam String issueDate,
                      Map<String, Object> model) {
        Card card = new Card(number, holder, issueDate);
        cardRepo.save(card);
        Iterable<Card> cards = cardRepo.findAll();
        model.put("cards", cards);
        return "main";
    }

}
