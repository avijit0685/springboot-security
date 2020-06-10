package com.tutorial.springboot.security.config;



import javax.print.attribute.standard.Fidelity;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringBootH2JDBCAuthentication extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	private static final String USERS_BY_USERNAME_QUERY = "SELECT username, password, enabled FROM users where username= ?";
	private static final String AUTHORITIES_BY_USERNAME_QUERY = "SELECT username, authority FROM authorities where username= ?";

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
								.usersByUsernameQuery(USERS_BY_USERNAME_QUERY)
								.authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("USER","ADMIN")
		.antMatchers("/").permitAll()
		.and().formLogin();
	}
}
