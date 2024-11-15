package com.learning.questionsApp.dto.Response;

import lombok.Data;

@Data
public class Login {
    private String email;
    private String password;

    public Login(String password, String email) {
        this.email = email;
        this.password = password;
    }
}
