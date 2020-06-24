package com.user.registration.controllers;

import com.user.registration.entities.User;
import com.user.registration.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List> showSignUpForm() {
        Iterable<User> users = userRepository.findAll();
        List<User> final_users = new ArrayList();
        for (User user : users)
            final_users.add(user);
        return new ResponseEntity<List>(final_users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> addUser(@RequestBody @Valid User user, Model model) {
        User valid_user = userRepository.findByEmail(user.getEmail());
        if (valid_user != null)
            return new ResponseEntity<String>("User with provided Credentials already Exists." +
                    "Please login! ", HttpStatus.BAD_REQUEST);
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return new ResponseEntity<String>("User created " + user, HttpStatus.CREATED);
    }

    @PostMapping("/login/")
    public ResponseEntity<String> login(@RequestBody @Valid User user, Model model) {
        User valid_user = userRepository.findByEmail(user.getEmail());
        if (valid_user == null) {
            return new ResponseEntity<String>("Invalid Credentials.Please SignUp!", HttpStatus.BAD_REQUEST);
        }
        if (!(valid_user.getPassword().equals(user.getPassword()))) {
            return new ResponseEntity<String>("Invalid Password ", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Welcome ", HttpStatus.OK);
    }
}
