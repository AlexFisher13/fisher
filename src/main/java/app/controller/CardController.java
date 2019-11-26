package app.controller;

import app.domain.Card;
import app.repos.CardRepo;
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
    private CardRepo cardRepo;

    @GetMapping("/cards")
    public String getCards(Map<String, Object> model) {
        Iterable<Card> cards = cardRepo.findAll();
        model.put("cards", cards);
        model.put("error", "");
        return "cards";
    }

    @PostMapping("/cards")
    public String addCard(@RequestParam String number,
                      @RequestParam String holder,
                      @RequestParam String issueDate,
                      Map<String, Object> model) {

        Pattern pattern = Pattern.compile("\\d{16}");
        if (!pattern.matcher(number).matches()) {
            model.put("error", "Ошибочка, братан, нужно ввести 16 цифр в поле номера карты");
            return "cards";
        }

        Card findCard = cardRepo.findByNumber(number);
        if (findCard != null) {
            model.put("error", "Ошибочка, братан, такая карта уже есть");
            return "cards";
        }

        Card newCard = new Card(number, holder, issueDate);
        cardRepo.save(newCard);
        Iterable<Card> cards = cardRepo.findAll();
        model.put("cards", cards);
        model.put("error", "");
        return "cards";
    }

}
