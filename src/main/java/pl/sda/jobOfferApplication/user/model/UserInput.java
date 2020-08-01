package pl.sda.jobOfferApplication.user.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserInput {
    private String uuid;
    private String name;
    private String login;
    private String creationDate;
    private String password;

    public UserInput(){
        uuid= UUID.randomUUID().toString();
        creationDate = "now";

    }
}
