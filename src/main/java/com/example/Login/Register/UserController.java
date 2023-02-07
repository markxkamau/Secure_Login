package com.example.Login.Register;

import com.example.Login.Dtos.RegisterDto;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/new_user")
    public String createUser(Model model) {
        model.addAttribute("user_info", new RegisterDto());
        return "Registration";
    }

    @PostMapping("/new_user")
    public String postNewUser(@ModelAttribute RegisterDto registerDto, @NotNull Model model) {
        if (!userService.checkPassword(registerDto.getPassword(),registerDto.getConfirmPassword())){
            model.addAttribute("password_error","Check password and try again");
            return "redirect:/user/new_user";
        }
        userService.createLogin(registerDto, userService.createUser(registerDto));
        return "redirect:/login";
    }
}
