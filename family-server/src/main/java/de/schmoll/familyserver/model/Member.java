package de.schmoll.familyserver.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String surname;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;

    public Member(String surname, String name, String email, String username, String password) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                       "id=" + id +
                       ", surname='" + surname + '\'' +
                       ", name='" + name + '\'' +
                       ", email='" + email + '\'' +
                       ", username='" + username + '\'' +
                       ", password='" + password + '\'' +
                       '}';
    }
}
