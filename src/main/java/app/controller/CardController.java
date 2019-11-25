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
import java.util.regex.Pattern;

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
        model.put("error", "");
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String number,
                      @RequestParam String holder,
                      @RequestParam String issueDate,
                      Map<String, Object> model) {

        Iterable<Card> cards = cardRepo.findAll();

        Pattern pattern = Pattern.compile("\\d{16}");


        if (!pattern.matcher(number).matches()) {
            model.put("error", "Ошибочка, братан, нужно ввести 16 цифр");
            return "main";
        }

        Card card = new Card(number, holder, issueDate);
        cardRepo.save(card);

        model.put("cards", cards);
        model.put("error", "");
        return "main";
    }

}
