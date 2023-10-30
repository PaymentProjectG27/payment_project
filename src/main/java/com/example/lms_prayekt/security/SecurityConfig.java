package com.example.lms_prayekt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers("register/amaliyot","register/jadval","/TableOfDars","/register/loginParol",
                                        "/lesson","/admin/{id}",
                                        "/{id}","Admin","Time"
                                        ,"/login", "/Sciences","/Dars","/register","/student")
                                .permitAll()
                                .requestMatchers("/car").hasAuthority("car:read")
                                .anyRequest().authenticated()
                )
                .formLogin(
                        loginConfig -> loginConfig
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/home")
                                .failureUrl("/login?error=true")
                                .usernameParameter("phoneNumber")
                                .passwordParameter("passcode")
                )
                .logout(
                        logoutConfig -> logoutConfig
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/student")
                )
                .rememberMe(
                        rememberMeConfig -> rememberMeConfig
                                .rememberMeCookieName("remember-me")
                                .tokenValiditySeconds(60 * 60 * 24)
                                .rememberMeParameter("rememberMe")
                )
                .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth,
                                UserDetailsService userDetailsService,
                                PasswordEncoder passwordEncoder) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails aziz = User.withDefaultPasswordEncoder()
//                .username("aziz")
//                .password("123")
//                .build();
//
//        UserDetails ahror = User.withDefaultPasswordEncoder()
//                .username("ahror")
//                .password("123")
//                .build();
//
//        return new InMemoryUserDetailsManager(aziz, ahror);
//    }


}
