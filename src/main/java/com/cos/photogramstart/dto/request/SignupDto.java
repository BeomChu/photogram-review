package com.cos.photogramstart.dto.request;

import com.cos.photogramstart.domain.User;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data //getter , setter
public class SignupDto {

    @Size(min = 2,max = 20)
    private String username;
    @NotBlank
    private String password;

    @NotBlank
    private String email;

    @NotBlank
    private String name;


    public User toEntity(){

        User user = User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .build();
        return user;
    }



}
