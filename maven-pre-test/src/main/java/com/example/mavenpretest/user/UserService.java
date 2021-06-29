package com.example.mavenpretest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void setRepository(UserRepository repo) {
        this.repo = repo;
    }

    public UserModel getUserById(int id) throws RuntimeException {
        Optional<User> result = repo.findById(id);
        if (result.isPresent()) {
            User user = result.get();
            return new UserModel(
                    user.getId(),
                    user.getName()
            );
        }
        throw new RuntimeException();
    }

    public UserModel addUser(User user) throws RuntimeException {
        User result = repo.save(user);
        if(result != null){
            return new UserModel(
                    result.getId(),
                    result.getName()
            );
        }
        throw new RuntimeException();
    }
}
