package app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter @Setter
public class Card {

    public Card() {
    }

    public Card(String number, String holder, Date issueDate) {
        this.number = number;
        this.holder = holder;
        this.issueDate = issueDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String number;
    private String holder;
    private Date issueDate;

}
