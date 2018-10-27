package de.schmoll.familyserver.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String surname;
    private String name;
//    private String email;
//    private String username;
//    private String password;

    public Member(String surname, String name, String email, String username, String password) {
        this.surname = surname;
        this.name = name;
//        this.email = email;
//        this.username = username;
//        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                       "id=" + id +
                       ", surname='" + surname + '\'' +
                       ", name='" + name + '\'' +
//                       ", email='" + email + '\'' +
//                       ", username='" + username + '\'' +
//                       ", password='" + password + '\'' +
                       '}';
    }
}
