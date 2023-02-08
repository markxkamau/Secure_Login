package com.example.Login.Login;

import com.example.Login.Dtos.LoginDto;
import com.example.Login.Register.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;
    public UserInfo getUserInfo(LoginDto loginDto) {
        UserLogin userLogin = loginRepository.findByEmail(loginDto.getUsername());
        return userLogin.getUser();
    }

    public boolean checkUser(LoginDto loginDto) {
        UserLogin userLogin = loginRepository.findByEmail(loginDto.getUsername());
        if (userLogin.getPasswordHash().equals(loginDto.getPassword()) && userLogin.getEmail().equals(loginDto.getUsername())){
            return true;
        }
        return false;
    }
}
