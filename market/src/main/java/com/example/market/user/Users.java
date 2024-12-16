package com.example.market.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginAt;

    public Users(String name, String s, String s1) {
    }


    // 계정이 생성되면 Role은 기본으로 USER, 생성 시간은 현재 시스템 시간으로 할당
    @PrePersist
    protected void onCreate() {
        this.role = "USER";
        this.createdAt = new Date(System.currentTimeMillis());
    }
}
