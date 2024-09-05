package com.demotest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {


    @Bean
    public InMemoryUserDetailsManager userDetailsManger() {

        UserDetails john = User.builder()
                .username("kiro")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails john2 = User.builder()
                .username("kiro2")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails john3 = User.builder()
                .username("kiro3")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, john2, john3);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config -> config.
                requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE").
                requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE").
                requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER").
                requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER").
                requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

        // use HTTP basic auth
        http.httpBasic(Customizer.withDefaults());

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
