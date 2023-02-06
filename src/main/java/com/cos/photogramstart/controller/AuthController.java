package com.cos.photogramstart.controller;


import com.cos.photogramstart.dto.request.SignupDto;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;



    @GetMapping("/auth/signin")
    public String signinForm(){
        return "/auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm(){
        return "/auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(@Valid SignupDto signupDto, BindingResult bindingResult){
        log.info("signupDto = {}" + signupDto);

        if(bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            log.error("fieldErrors={}",errors);
            throw new CustomValidationException(1,"유효성 검사 실패", errors);
        }else{
            authService.join(signupDto);
        }


        return "/auth/signin";
    }
}
