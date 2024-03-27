package com.ceica.securityspring.config;
import com.ceica.securityspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public SecurityConfig(UserService userService,CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler){
        this.userService = userService;
        this.authenticationSuccessHandler=customAuthenticationSuccessHandler;
    }

/*
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
*/
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/img/**","/js/**","/css/**").permitAll()
                        .requestMatchers("/","/coches").permitAll()
                        .requestMatchers("/cochescontroller").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .successHandler(authenticationSuccessHandler)
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll
                );
        http
                .csrf(AbstractHttpConfigurer::disable);
        // Ignorar los archivos estáticos

        return http.build();
    }
}