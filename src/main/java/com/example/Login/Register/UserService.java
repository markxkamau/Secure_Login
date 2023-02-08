package com.example.Login.Register;

import com.example.Login.Dtos.RegisterDto;
import com.example.Login.Login.LoginRepository;
import com.example.Login.Login.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;

    public void createUser(RegisterDto registerDto) {
        UserInfo userInfo = new UserInfo(registerDto.getId(), registerDto.getFirstName(), registerDto.getLastName());
        userRepository.save(userInfo);
    }

    public void createLogin(RegisterDto registerDto) {
        UserInfo userInfo = new UserInfo(
                registerDto.getId(),
                registerDto.getFirstName(),
                registerDto.getLastName()
        );
        UserLogin userLogin = new UserLogin(
                registerDto.getId(),
                registerDto.getEmail(),
                registerDto.getPassword(),
                registerDto.getConfirmPassword(),
                userInfo
        );
        loginRepository.save(userLogin);
    }

    private String getPasswordSalt() {
        return null;
    }

    private String getPasswordHash(String password) {
        return null;
    }

    public boolean checkPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return true;
        }
        return false;
    }
}
