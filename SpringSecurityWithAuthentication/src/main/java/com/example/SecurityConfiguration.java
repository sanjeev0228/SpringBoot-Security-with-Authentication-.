package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		//Set configuration on the auth object
		auth.inMemoryAuthentication()
		.withUser("Sanjeev").password("Sanjeev@123").roles("User")
		  .and()
		 .withUser("kabita").password("kabita@123").roles("Admin"); 
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}
	
	protected void configure (HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.antMatchers("/admin").hasRole("Admin")
		.antMatchers("/user").hasAnyRole("Admin" ,"User")
		.and().formLogin();
		
	}
		
	}
	
	
	


