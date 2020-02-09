package ru.cetelem.ucbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= { "ru.cetelem.ucbservice.config", "ru.cetelem.ucbservice.service" })
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); 
    }
}