package com.example.project_ps_real.controller;

import com.example.project_ps_real.entity.User;
import com.example.project_ps_real.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> getAllUsers(){
        return this.userService.retrieveUsers();
    }

    @GetMapping("/getById")
    @ResponseBody
    public User getUsertById(@RequestParam("id") Long id) {
        User user =this.userService.retrieveUserById(id);
        return user;
    }

    @PostMapping("/addUser")
    @ResponseBody
    public User insertUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/updateUser")
    @ResponseBody
    public User updateUser(@RequestBody User user){
        return this.userService.updateUser(user);
    }



    @DeleteMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam Long id){
        return this.userService.deleteUserById(id);
    }
}
