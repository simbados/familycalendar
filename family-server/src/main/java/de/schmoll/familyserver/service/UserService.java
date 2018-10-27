package de.schmoll.familyserver.service;

import de.schmoll.familyserver.model.Member;
import de.schmoll.familyserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public Iterable<Member> getAllUsers() {
        return repository.findAll();
    }

    public Member postUser(Member member) {
        return repository.save(member);
    }

}
