package pe.jccallo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan
public class Configure extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user01").password(codificapassword().encode("123456")).roles("USER")
		.and().withUser("user02").password(codificapassword().encode("123456")).roles("USER")
		.and().withUser("user03").password(codificapassword().encode("123456")).roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/contenido").authenticated()
		.antMatchers("/user").authenticated()
		.and().httpBasic();
	}

	@Bean
	public BCryptPasswordEncoder codificapassword() {
		return new BCryptPasswordEncoder();
	}
}	
