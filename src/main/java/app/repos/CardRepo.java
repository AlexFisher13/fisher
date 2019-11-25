package app.repos;

import app.domain.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepo extends CrudRepository<Card, Long> {

    Card findByNumber(String number);

}
