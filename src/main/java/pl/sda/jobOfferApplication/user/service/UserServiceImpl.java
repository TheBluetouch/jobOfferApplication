package pl.sda.jobOfferApplication.user.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.jobOfferApplication.user.entity.UserEntity;
import pl.sda.jobOfferApplication.user.exception.UserException;
import pl.sda.jobOfferApplication.user.model.UserInput;
import pl.sda.jobOfferApplication.user.model.UserOutput;
import pl.sda.jobOfferApplication.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final String NO_USER_FOUND_FOR_GIVEN_ID = "No user found for given id";
    public static final String USER_ALREADY_EXISTS_IN_THE_DATABASE = "User already exists in the database ";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository=userRepository;
//    }

    @Override
    public void createUser(UserInput userInput) throws UserException {

        existsUserInput(userInput);
        final String encode = passwordEncoder.encode(userInput.getPassword());


        final UserEntity userEntity =
                new UserEntity(userInput.getName(),
                        userInput.getLogin(),
                        userInput.getCreationDate(),
                        encode);
        userRepository.save(userEntity);
    }

    @Override
    public List<UserOutput> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserEntity::toOutput)
                .collect(Collectors.toList());
    }

    @Override
    public UserOutput getUserById(Long id) throws UserException {
        final Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (!optionalUserEntity.isPresent()) {
            throw new UserException(NO_USER_FOUND_FOR_GIVEN_ID);
        }

        return optionalUserEntity.get().toOutput();
    }



    @Override
    public void existsUserInput(UserInput userInput) throws UserException {
        if(userRepository.existsByLogin(userInput.getLogin()))
        throw new UserException(USER_ALREADY_EXISTS_IN_THE_DATABASE);

    }
}
