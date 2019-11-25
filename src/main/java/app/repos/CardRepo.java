package app.repos;

import app.domain.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepo extends CrudRepository<Card, Long> {
}
