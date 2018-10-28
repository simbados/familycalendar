package de.schmoll.familyserver.Validator;

import de.schmoll.familyserver.model.Member;
import de.schmoll.familyserver.repository.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.util.Optional;

@Component
public class UserValidator {

    //TODO: Write Unit tests

    @Autowired
    UserRepository userRepository;

    public void validate(Member data, Errors errors) {
        validateEmail(data.getEmail(), errors);
        validateUserName(data.getUsername(), errors);
//        validateName(data.getName(), errors);
//        validateName(data.getSurname(), errors);

    }

    // TODO: Check if not null validation is archieved through NotNull annotation in Member class
//    private void validateName(String name, Errors errors) {
//        if(name == null){
//            errors.reject(name.getClass().getCanonicalName() + "must not be empty");
//        }
//    }

    private void validateUserName(String username, Errors errors) {
        if (Optional.ofNullable(userRepository.findMemberByUsername(username)).isPresent()) {
            errors.reject("User Name is already used");
        }
    }

    private void validateEmail(String email, Errors errors) {
        if (!EmailValidator.getInstance().isValid(email)) {
            errors.reject("Email Address is not valid");
        }
    }
}
