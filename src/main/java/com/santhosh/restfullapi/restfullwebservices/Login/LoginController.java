package com.santhosh.restfullapi.restfullwebservices.Login;

import com.santhosh.restfullapi.restfullwebservices.User.User;
import com.santhosh.restfullapi.restfullwebservices.User.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(path = "/login")
    public String login() {
        return "LOGGED IN";
    }

    @GetMapping(path = "login-bean")
    public LoginBean loginBean() {
        return new LoginBean("Login Bean");
    }
}
