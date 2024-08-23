package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Scope {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private String type;
}
