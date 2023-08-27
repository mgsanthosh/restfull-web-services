package com.santhosh.restfullapi.restfullwebservices.User;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService service) {
        this.userDaoService = service;
    }

    @GetMapping(path = "/all-users")
    public List<User> allUsers() {
        return userDaoService.getAllUsers();
    }

    @GetMapping(path = "/auth/{userName}/{password}")
    public int isAuthenticated(@PathVariable String userName, @PathVariable String password) {
        return userDaoService.checkForAuthentication(userName, password);
    }

    @PostMapping(path = "/addUser")
    public boolean createUser(@RequestBody User user) {
        return userDaoService.addUser(user);
    }

}
