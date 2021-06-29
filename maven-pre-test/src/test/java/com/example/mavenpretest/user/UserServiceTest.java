package com.example.mavenpretest.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository repo;

//    @Autowired
//    private UserService service;

    @Test
    void getUserById() {
        User mock = new User(1,"Ten",20000);
        when(repo.findById(1)).thenReturn(Optional.of(mock));
        UserService service = new UserService();
        service.setRepository(repo);
        UserModel result = service.getUserById(1);
        assertEquals(1,result.getId());
        assertEquals("Ten",result.getName());
    }
}