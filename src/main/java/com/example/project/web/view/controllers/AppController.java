package com.example.project.web.view.controllers;

import com.example.project.data.dto.RoleDTO;
import com.example.project.data.dto.UserDTO;
import com.example.project.data.entity.User;
import com.example.project.data.repository.UserRepository;
import com.example.project.services.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl service;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        for(User u: userRepository.findAll()){
            if(u.getEmail().equals(user.getEmail())) {
                return "register_failure";
            }
        }
        userRepository.save(user);
        return "register_success";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        /*List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);*/
        /**List<User> userList = service.listAll();*/
        List<UserDTO> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/edit-user/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        //User user = service.get(id);
        UserDTO user = service.get(id);
        //List<Roles> listRoles = service.listRoles();
        List<RoleDTO> listRoles = service.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);
        return "edit-user";
    }

}
