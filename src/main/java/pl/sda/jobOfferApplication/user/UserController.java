package pl.sda.jobOfferApplication.user;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.jobOfferApplication.user.model.UserInput;
import pl.sda.jobOfferApplication.user.model.UserOutput;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    @GetMapping

    //    public UserOutput getUser() {
//
//        return new UserOutput("Adam", "adam123", "321321321");
//
//    }
    @GetMapping
    public ResponseEntity<List<UserOutput>> getAllUsers() {

        final UserOutput userOutput = new UserOutput(2135486L, "Adam", "adam123", "321321321");


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Collections.singletonList(userOutput));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutput> getUserById(@PathVariable(value = "id") Long id) {

        System.out.println(id);
        final UserOutput userOutput = new UserOutput(20135486L, "Adam", "adam123", "321321321");


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userOutput);
    }

//    public ResponseEntity<Void> postUser() {
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .build();
//    }

    @PostMapping
    public ResponseEntity<Void> postUser(@RequestBody UserInput userInput) {

        System.out.println(userInput);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

}
