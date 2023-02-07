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

    public User createUser(RegisterDto registerDto) {
        User user = new User(registerDto.getFirstName(), registerDto.getLastName());
        return user;
    }

    public void createLogin(RegisterDto registerDto, User user) {
        UserLogin userLogin = new UserLogin(
                registerDto.getEmail(),
                getPasswordHash(registerDto.getPassword()),
                getPasswordSalt(),
                user
        );
        userRepository.save(user);
        loginRepository.save(userLogin);

    }

    private String getPasswordSalt() {
        return null;
    }

    private String getPasswordHash(String password) {
        return null;
    }

    public boolean checkPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)){
            return true;
        }
        return false;
    }
}
