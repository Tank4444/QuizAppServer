package ru.chuikov.config.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;
import java.util.Date;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security
//                .tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()")
//                .allowFormAuthenticationForClients();
//    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Autowired
    private DataSource dataSource;
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                .inMemory()
//                .withClient("app")
//                .secret(encoder.encode("app"))
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
//                .authorities("READ_ONLY_CLIENT")
//                .scopes("read_profile_info")
//                .resourceIds("oauth2-resource")
//                .redirectUris("http://localhost:8080/login")
//                .accessTokenValiditySeconds(5000)
//                .refreshTokenValiditySeconds(50000);

        clients
                .inMemory()
                //.jdbc(dataSource).passwordEncoder(encoder)
                .withClient("app").secret(encoder.encode("app"))
                .authorizedGrantTypes("password", "refresh_token")
                .authorities("CLIENT")
                .scopes("all")
                .accessTokenValiditySeconds(60*60)//sec * min = 1 hour
        ;
    }
}
