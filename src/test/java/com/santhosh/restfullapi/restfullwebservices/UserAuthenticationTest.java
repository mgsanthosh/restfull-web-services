package com.santhosh.restfullapi.restfullwebservices;

import com.santhosh.restfullapi.restfullwebservices.User.User;
import com.santhosh.restfullapi.restfullwebservices.User.UserDaoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserAuthenticationTest {

    @Autowired
    private UserDaoService userDaoService;

//    @Test
//    void testAddUser() {
//        User newUser = new User(5, "NewUser", "newpassword");
//        userDaoService.addUser(newUser);
//        List<User> allUsers = userDaoService.getAllUsers();
//        assertTrue(allUsers.contains(newUser));
//    }

//    @Test
//    void testAuthentication() {
//        assertTrue(userDaoService.checkForAuthentication("Santhosh", "abcd@123"));
//        assertFalse(userDaoService.checkForAuthentication("alice", "wrongpass"));
//        assertFalse(userDaoService.checkForAuthentication("eve", "hackme"));
//    }
}
