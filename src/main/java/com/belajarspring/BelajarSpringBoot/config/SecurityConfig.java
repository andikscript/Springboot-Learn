package com.belajarspring.BelajarSpringBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // memberitahu ke framework agar tidak mengenerete password dan menggunakan username password di bawah ini
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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

