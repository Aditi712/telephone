package com.example.Telephone.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UserDetailsService userDetailsServiceObject;

    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsServiceObject);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.cors().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/add").hasAuthority("user")
                .antMatchers("/display-All").hasAnyAuthority("manager", "admin")
                .antMatchers("/display-by-id/{id}").hasAnyAuthority("manager", "admin")
                .antMatchers("/display-by-name/{name}").hasAnyAuthority("manager", "admin")
                .antMatchers("/display-by-address/{address}").hasAnyAuthority("manager", "admin")
                .antMatchers("/display-by-email/{email}").hasAnyAuthority("manager", "admin")
                .antMatchers("/update/{id}").hasAuthority("manager")
                .antMatchers("/delete-by-id/{id}").hasAnyAuthority("manager", "admin")
                .antMatchers("delete-all").hasAuthority("admin")
                .anyRequest().authenticated().and().httpBasic();
    }
}
