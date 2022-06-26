package pe.jccallo.seguridad;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@ComponentScan
public class Configuracion extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication()
			.withUser("luis").password(passwordEncoder().encode("123456")).roles("USER")
			.and().withUser("cecilia").password(passwordEncoder().encode("123456")).roles("USER");
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.anonymous().disable();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	@Order(0)
	public FilterRegistrationBean filterRegistrationBean() {
			UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
			CorsConfiguration config=new CorsConfiguration();
			config.setAllowCredentials(true);
			config.addAllowedOrigin("*");
			config.addAllowedHeader("*");
			config.addAllowedMethod("*");
			source.registerCorsConfiguration("/**", config);	
			return new FilterRegistrationBean(new CorsFilter(source));
	}
			
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}			
}

