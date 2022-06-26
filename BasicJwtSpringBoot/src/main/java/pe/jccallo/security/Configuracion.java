package pe.jccallo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Configuracion extends WebSecurityConfigurerAdapter{
	private static final String usuario = "admin";
	private static final String clave = "123456";
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.inMemoryAuthentication().withUser(usuario)
		.password(codifica().encode(clave))
		.roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.csrf().disable().authorizeRequests()
		.antMatchers("/acceso").permitAll()
		.antMatchers("/vendedor").access("hasRole('ADMIN')") 
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(new ValidarLogin("/acceso", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new ValidarToken(clave), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public PasswordEncoder codifica() {
		return new BCryptPasswordEncoder();
	}
}
