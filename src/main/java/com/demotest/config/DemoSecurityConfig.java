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
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    /**
     * Add support for JDBC
     */
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Query to retrieve users by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, pass, enabled from members where username=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from roles where username=?");

        return jdbcUserDetailsManager;
    }






    /**
     * This code is hardcoded just for testing the 2 functions below
     */

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManger() {
//
//        UserDetails john = User.builder()
//                .username("kiro")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails john2 = User.builder()
//                .username("kiro2")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails john3 = User.builder()
//                .username("kiro3")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, john2, john3);
//    }

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
