package com.shivam.e_commerce.backend.config;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}