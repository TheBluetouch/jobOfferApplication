package pl.sda.jobOfferApplication.user.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserInput {
    private Long uuid;
    private String name;
    private String login;
    private LocalDate creationDate;
    private String password;

    public UserInput() {
        creationDate = LocalDate.now();

    }
}
