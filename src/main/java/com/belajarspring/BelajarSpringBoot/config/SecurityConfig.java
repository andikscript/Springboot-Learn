package com.belajarspring.BelajarSpringBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// anotasi @Configuration memberitahu ke framework agar tidak mengenerete password dan
// menggunakan username password di method configure(AuthenticationManagerBuilder auth)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // method berikut digunakan untuk membuat username dan password ketika mengakses
    // web (jika ada login page) atau api
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin")
                .roles("USER","ADMIN");
    }

    // method ini digunakan untuk mapping url yang  diberikan authentication
    // dan jika tidak diberi method ini maka akses localhost pertama akan terdapat login page
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/Api/mahasiswa/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/Api/mahasiswa").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/Api/mahasiswa").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/Api/mahasiswa/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}

