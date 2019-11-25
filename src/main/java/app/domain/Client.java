package app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Client {

    public Client() {
    }

    public Client(String firstname, String lastname, String midname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.midname = midname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstname;
    private String lastname;
    private String midname;
}
