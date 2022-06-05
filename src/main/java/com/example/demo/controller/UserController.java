package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "createuser", method = RequestMethod.POST)
    public String createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "readusers", method = RequestMethod.GET)
    public List<User> readUsers(){
        return userService.readUsers();
    }

    @RequestMapping(value = "authenticateuser", method = RequestMethod.POST)
    public String readUser(@RequestBody User user){
        return userService.readUser(user);
    }

    @RequestMapping(value = "updateuser", method = RequestMethod.PUT)
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @RequestMapping(value = "deleteuser", method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

}
