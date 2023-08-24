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

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("test");
        userDaoService.addUser(user);
        List<User> allUsers = userDaoService.getAllUsers();
        System.out.println("THE USER");
        System.out.println(allUsers);
        System.out.println(allUsers.contains(user));
//        assertTrue(allUsers.contains(user));

    }

    @Test
    void testAuthentication() {
        assertTrue(userDaoService.checkForAuthentication("santhosh", "abcd"));
        assertFalse(userDaoService.checkForAuthentication("alice", "wrongpass"));
        assertFalse(userDaoService.checkForAuthentication("eve", "hackme"));
    }
}
