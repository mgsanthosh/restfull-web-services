package com.santhosh.restfullapi.restfullwebservices.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class UserDaoService {

    @Autowired
    private UserRepository userRepository;
    private static List<User> users = new ArrayList<>();
//    static {
//        users.add(new User(1, "Santhosh", "abcd@123"));
//        users.add(new User(2, "Adam", "abcd@123"));
//        users.add(new User(3, "Arun", "abcd@123"));
//        users.add(new User(4, "Saran", "abcd@123"));
//    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public int checkForAuthentication(String userName, String password) {
        users = getAllUsers();
        for(User user: users) {
            if(user.getUsername().equals(userName) && user.getPassword().equals(password)) {
                return user.getId();
            }
        }
        return -1;
    }

    public boolean addUser(User user) {
        if(checkForAuthentication(user.getUsername(), user.getPassword()) == -1) {
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }


}