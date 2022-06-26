package pe.jccallo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class ValidarToken extends GenericFilterBean {
	String clave = "";
	public ValidarToken(String clave) {
		this.clave = clave;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Authentication autentica = Token.AutenticarTokenCliente((HttpServletRequest)request, this.clave);
		SecurityContextHolder.getContext().setAuthentication(autentica);	
		chain.doFilter(request, response);
	}	
}
