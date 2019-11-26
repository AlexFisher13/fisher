package app.controller;

import app.domain.Card;
import app.repos.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Map;

@Controller
@Validated
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
    public String addCard(@Valid @Pattern(regexp = "\\d{16}") @RequestParam String number,
                          @RequestParam String holder,
                          @RequestParam String issueDate,
                          Map<String, Object> model) {

        if (cardRepo.findByNumber(number) != null) return "error";

        cardRepo.save(new Card(number, holder, issueDate));
        Iterable<Card> cards = cardRepo.findAll();
        model.put("cards", cards);
        return "cards";
    }
}
