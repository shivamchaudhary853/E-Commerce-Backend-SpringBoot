package com.shivam.e_commerce.backend.service;

import com.shivam.e_commerce.backend.Repository.UserRepository;
import com.shivam.e_commerce.backend.dto.Loginrequest;
import com.shivam.e_commerce.backend.dto.RegisterRequest;
import com.shivam.e_commerce.backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.shivam.e_commerce.backend.security.JwtService;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public String Register(RegisterRequest request) {

        if (userRepository.findByemail(request.getEmail()).isPresent()) {
            return "Email is Already Present";
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER")
                .build();

        userRepository.save(user);
        return "User Registered Successfully";
    }
    public String Login(Loginrequest request){

        User user = userRepository.findByemail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));


        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            return "Invalid Password";
        }
        return  jwtService.generateToken(user.getEmail());
    }
}
