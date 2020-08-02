package pl.sda.jobOfferApplication.user.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserOutput {
    public UserOutput(Long id, String name, String login, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.creationDate = creationDate;
    }

    private Long id;
    private String name;
    private String login;
    private LocalDate creationDate;


}
