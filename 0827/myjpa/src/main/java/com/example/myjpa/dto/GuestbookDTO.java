package com.example.myjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestbookDTO {
    private String writer;
    private String pwd;
    private String content;
}

