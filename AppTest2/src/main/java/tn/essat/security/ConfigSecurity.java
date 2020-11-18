package tn.essat.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
    DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	PasswordEncoder crypt = cryptMP();
//   System.out.println(crypt.encode("essat"));
//		auth.inMemoryAuthentication().withUser("safa").password(crypt.encode("essat")).roles("USER");
//		auth.inMemoryAuthentication().withUser("salah").password(crypt.encode("essat")).roles("ADMIN","USER");

		
   auth.jdbcAuthentication()
       .dataSource(dataSource)
       .usersByUsernameQuery("select username as principale, password as credentials, active from user where username=?")
       .authoritiesByUsernameQuery("select user_username as principale,roles_role as role from user_roles where user_username=?")
       .passwordEncoder(crypt)
       .rolePrefix("ROLE_");
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error=true").permitAll();
		//http.httpBasic();
		http.authorizeRequests().antMatchers("/ajout**/**","/delete**/**").hasRole("ADMIN");	
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().anyRequest().authenticated();	
	    http.exceptionHandling().accessDeniedPage("/notAuthorise");
	    http.csrf().disable(); 
	}
	@Bean
	public PasswordEncoder cryptMP() {
		return new BCryptPasswordEncoder();
	}
}
