package com.GabrielVitor.CRUDSpring.controller;

import com.GabrielVitor.CRUDSpring.DTO.UserRequestDTO;
import com.GabrielVitor.CRUDSpring.DTO.UserResponseDTO;
import com.GabrielVitor.CRUDSpring.infrastructure.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody User dto){
        UserResponseDTO savedUser = userService.save(User dto);
        return ResponseEntity.ok(savedUser);
    }

}
