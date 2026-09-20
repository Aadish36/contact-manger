package com.smart.contact.manger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.springframework.security.authorization.SingleResultAuthorizationManager.permitAll;


@Configuration
@EnableWebSecurity
public class myconfig extends WebSecurityConfigura {
    @Bean
    public UserDeatilServiceImpl getUserDetailService() {
    return new UserDeatilService();
}
@Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
}
@Bean
public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsPasswordService(this.getUserDetailService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
}
///configure mathode
  @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    protected  void configure(HttpSecurity http) throws Exception {
      http.authorizeHttpRequests().antMatcher("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER").antMatchers("/**")permitAll().and().formaLogin().and().csrf().disable();
    }
}
