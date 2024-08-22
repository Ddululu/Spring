package com.example.demo.scope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Member {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private String type;
}
