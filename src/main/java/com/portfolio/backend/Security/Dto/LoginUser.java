package com.portfolio.backend.Security.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class LoginUser {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;

}
