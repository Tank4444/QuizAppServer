package ru.chuikov;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.chuikov.entity.User;
import ru.chuikov.entity.UserRole;
import ru.chuikov.service.UserService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.chuikov.repository")
@EnableTransactionManagement
@EntityScan(basePackages = "ru.chuikov.entity")
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
                    User.builder()
                            .email("mail")
                            .first_name("fn")
                            .last_name("ln")
                            .org_name("ORG")
                            .role(UserRole.USER)
                            .password("mail")
                            .build());
        };
    }
}