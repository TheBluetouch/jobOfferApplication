package pl.sda.jobOfferApplication.user.entity;

import com.sun.xml.bind.v2.runtime.output.MTOMXmlOutput;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.sda.jobOfferApplication.user.model.UserOutput;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public UserEntity(String name, String login,
                      LocalDate creationDate, String password) {
        this.name=name;
        this.login=login;
        this.creationDate=creationDate;
        this.password=password;
    }

    private String name;
    private String login;
    private LocalDate creationDate;
    private String password;


    public UserOutput toOutput(){
        return new UserOutput(id,name,login,creationDate);

    }
}
