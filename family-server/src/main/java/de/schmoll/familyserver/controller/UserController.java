package de.schmoll.familyserver.controller;

import de.schmoll.familyserver.model.Member;
import de.schmoll.familyserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers () {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<?> postUser (@RequestBody Member member) {
        return new ResponseEntity<>(userService.postUser(member), HttpStatus.CREATED);
    }
}
