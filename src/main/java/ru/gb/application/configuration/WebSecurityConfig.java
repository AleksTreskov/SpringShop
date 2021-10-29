package ru.gb.application.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest()
                .permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().
                formLogin().
                loginPage("/auth/login").
                loginProcessingUrl("/auth/login").permitAll()
                .and()
                .logout()
                .logoutUrl("/auth/logout")
                .logoutSuccessUrl("/");
    }
}
