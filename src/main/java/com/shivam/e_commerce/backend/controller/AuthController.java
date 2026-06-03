package com.shivam.e_commerce.backend.controller;

import com.shivam.e_commerce.backend.dto.Loginrequest;
import com.shivam.e_commerce.backend.dto.RegisterRequest;
import com.shivam.e_commerce.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public String Register(@RequestBody RegisterRequest request){
        return userService.Register(request);
    }

    @PostMapping("/Login")
    public String Login(@RequestBody Loginrequest request){
        return userService.Login(request);
    }
}
