package com.amazon.starter.controller;

import com.amazon.starter.domain.User;
import com.amazon.starter.repository.UserRepository;
import com.amazon.starter.repository.dbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author: John Zhang
 * @date: 1/17/20
 * @decription:
 **/

@RestController
@RequestMapping("/users")
public class UserContrller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private dbRepository dbRepository;

    @GetMapping
    public ModelAndView list(Model model){
        model.addAttribute("userList",userRepository.listUsers());
        model.addAttribute("title","Manage Users");
        //The page source based on the viewName.
        //userModel is the name of model in HTML5.
        return new ModelAndView("user/list","userModel",model);
    }

    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","Search User");
        return new ModelAndView("user/view","userModel",model);
    }

    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","Create New User");
        return new ModelAndView("user/form","userModel",model);
    }

    @PostMapping()
    public ModelAndView saveOrUpdateUser(User user){
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id){
        userRepository.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/modify/{id}")
    public ModelAndView modifyUser(@PathVariable("id") Long id,Model model){
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","Modify User");
        return new ModelAndView("user/form","userModel",model);
    }
}
