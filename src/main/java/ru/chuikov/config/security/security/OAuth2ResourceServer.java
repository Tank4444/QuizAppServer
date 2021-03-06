package ru.chuikov.config.security.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@RequiredArgsConstructor
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/reg").permitAll()
                .antMatchers("/api/**").authenticated();
    }
}
