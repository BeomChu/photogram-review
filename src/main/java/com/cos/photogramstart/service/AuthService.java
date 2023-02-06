package com.cos.photogramstart.service;

import com.cos.photogramstart.domain.User;
import com.cos.photogramstart.dto.request.SignupDto;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User join(SignupDto signupDto){
        String encode = bCryptPasswordEncoder.encode(signupDto.getPassword());
        signupDto.setPassword(encode);
        if(userRepository.existsByUsername(signupDto.getUsername())){
            throw new CustomValidationException(-1,"아이디 중복됨",null);
        }else{
           return userRepository.save(signupDto.toEntity());
        }
    }
}
