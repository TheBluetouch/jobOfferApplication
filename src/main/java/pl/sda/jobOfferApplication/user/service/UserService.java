package pl.sda.jobOfferApplication.user.service;

import pl.sda.jobOfferApplication.user.entity.UserEntity;
import pl.sda.jobOfferApplication.user.exception.UserException;
import pl.sda.jobOfferApplication.user.model.UserInput;
import pl.sda.jobOfferApplication.user.model.UserOutput;

import java.util.List;

public interface UserService {
    public void createUser(UserInput userInput) throws UserException;

    List<UserOutput> getAllUsers();

    public UserOutput getUserById(Long id) throws UserException;

    public void existsUserInput(UserInput userInput) throws UserException;

}