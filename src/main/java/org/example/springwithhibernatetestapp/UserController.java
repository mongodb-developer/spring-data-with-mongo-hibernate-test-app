package org.example.springwithhibernatetestapp;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @PostMapping("/user")
    public User createUser() {
        User u = new User("test name");
        this.userRepository.save(u);
        return u;
    }
}
