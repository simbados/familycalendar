package de.schmoll.familyserver.controller;

import de.schmoll.familyserver.Validator.UserValidator;
import de.schmoll.familyserver.model.Member;
import de.schmoll.familyserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserValidator userValidator;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers () {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> postUser (@Valid @RequestBody Member member, Errors errors) {
        userValidator.validate(member, errors);
        if (errors.hasErrors()) {
            return new ResponseEntity<>(getErrorString(errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.postUser(member), HttpStatus.CREATED);
    }

    private String getErrorString(Errors errors) {
        return errors.getAllErrors().stream().map(ObjectError::toString).collect(Collectors.joining(","));
    }
}
