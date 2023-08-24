package com.santhosh.restfullapi.restfullwebservices;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.santhosh.restfullapi.restfullwebservices.User.User;
import com.santhosh.restfullapi.restfullwebservices.User.UserDaoService;
import com.santhosh.restfullapi.restfullwebservices.User.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDaoService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCheckForAuthentication_ValidCredentials() {
        // Create mock users
        User user1 = new User(1, "username1", "password1");
        User user2 = new User(2, "username2", "password2");
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(user1);
        mockUsers.add(user2);

        // Mock the behavior of the userRepository.findAll() method
        when(userRepository.findAll()).thenReturn(mockUsers);

        // Call the service method with valid credentials
        int userId = userService.checkForAuthentication("username1", "password1");

        // Verify the result
        assertEquals(1, userId); // Expecting the user ID of the first user
    }

    @Test
    public void testCheckForAuthentication_InvalidCredentials() {
        // Create mock users
        User user1 = new User(1, "username1", "password1");
        User user2 = new User(2, "username2", "password2");
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(user1);
        mockUsers.add(user2);

        // Mock the behavior of the userRepository.findAll() method
        when(userRepository.findAll()).thenReturn(mockUsers);

        // Call the service method with invalid credentials
        int userId = userService.checkForAuthentication("invalidUsername", "invalidPassword");

        // Verify the result
        assertEquals(-1, userId); // Expecting -1 for invalid credentials
    }
}
