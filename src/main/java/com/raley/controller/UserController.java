package com.raley.controller;

import com.raley.model.ApiResponse;
import com.raley.model.User;
import com.raley.model.UserDto;
import com.raley.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author abhay.thakurr
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ApiResponse<User> saveVendor(@RequestBody UserDto user){
    	if(userService.findOne(user.getEmail())!=null) {
            return new ApiResponse<>(HttpStatus.OK.value(), "User already exist.!",null);
    	}else {
            return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    	}
    }

    @GetMapping("/list")
    public ApiResponse<List<User>> listUser(){
        return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @GetMapping("/getUser/{id}")
    public ApiResponse<User> getOne(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    }

    @PutMapping("/updateUser/{id}")
    public ApiResponse<UserDto> updateVendor(@RequestBody UserDto userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ApiResponse<Void> deleteVendor(@PathVariable int id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
