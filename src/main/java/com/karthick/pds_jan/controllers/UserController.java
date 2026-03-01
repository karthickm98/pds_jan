package com.karthick.pds_jan.controllers;


import com.karthick.pds_jan.dtos.CreateUserDto;
import com.karthick.pds_jan.dtos.GetInstructorDto;
import com.karthick.pds_jan.models.Instructor;
import com.karthick.pds_jan.models.User;
import com.karthick.pds_jan.services.UserService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User createUser(@RequestBody CreateUserDto createUserDto){

        return userService.createUser(createUserDto.getName(), createUserDto.getEmail());

    }

    @PostMapping("/instructor")
    public Instructor createInstructor(@RequestBody CreateUserDto createUserDto){

        return userService.createInstructor(createUserDto.getName(), createUserDto.getEmail());

    }

    @GetMapping("/{name}")
    public List<User> getUserByName(@PathVariable(name = "name") String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/instructor/{name}")
    public List<GetInstructorDto> getInstructorByName(@PathVariable(name = "name") String name){
        return userService.getInstructorByName(name);
    }

    @GetMapping("/instructor")
    public List<GetInstructorDto> getInstructorByUUID(@RequestBody List<UUID> uuid){
        return userService.getInstructorByIds(uuid);
    }



}
