package ru.chuikov;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.chuikov.entity.User;
import ru.chuikov.entity.UserRole;
import ru.chuikov.service.UserService;

@SpringBootApplication
public class Initializer {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    public static void main(String[] args) {
        SpringApplication.run(Initializer.class);
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {
            userService.add(
                    new User(
                            1L,
                            "mail",
                            "mail",
                            "fn",
                            "ln",
                            "ORG",
                            null,
                            null,
                            UserRole.USER
                            ));
        };
    }
}