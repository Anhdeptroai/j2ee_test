package com.example.SGUCharity_Project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@Controller
public class Login_admin_controller<UserDetails> {

    @GetMapping("/login")
    public String logout() {
        return "account_admin/SignIn";
    }

}
