package pe.jccallo.security;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.jccallo.model.Usuario;

public class ValidarLogin extends AbstractAuthenticationProcessingFilter {
	Usuario usuario;
	
	public ValidarLogin(String url,AuthenticationManager au) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(au);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		InputStream body = request.getInputStream();
		usuario = new ObjectMapper().readValue(body, Usuario.class);
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(usuario.getNombre(), usuario.getClave()));						
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException { 
		Token.CrearToken(response, authResult.getName());
	}	
}
