package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "index"; // This will point to index.html
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "redirect:/"; // Redirect to home after adding
    }
}