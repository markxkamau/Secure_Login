package com.example.Login.Login;

import com.example.Login.Dtos.LoginDto;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String setLoginSession(@NotNull Model model) {
        model.addAttribute("login_info", new LoginDto());
        return "Login_Page";
    }

    @PostMapping("/login")
    public String startLoginSession(HttpServletRequest httpServletRequest, @ModelAttribute LoginDto loginDto, @NotNull RedirectAttributes redirectAttributes) {
        if (!loginService.checkUser(loginDto)) {
            redirectAttributes.addFlashAttribute("login_error", "Invalid credentials, check email or password");
            return "redirect:/login";
        }
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("user_info", loginService.getUserInfo(loginDto));
        return "Reference";
    }
}
