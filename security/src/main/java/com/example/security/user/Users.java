package com.example.security.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    @Id
    private String id;
    private String name;
    private String password;
    private String role;

    public Users(String id, String encode) {
    }
}
