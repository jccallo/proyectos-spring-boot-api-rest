package pe.jccallo.security;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Token {
	static void CrearToken(HttpServletResponse res, String username) {
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + 300000))
				.signWith(SignatureAlgorithm.HS512,"jccallo@outlook.com")
				.compact();
		res.addHeader("Authorization", "Bearer " + token);
	}
	
	static Authentication AutenticarTokenCliente(HttpServletRequest request, String clave) {
		String token = request.getHeader("Authorization");
		if (token != null) {
			String user = Jwts.parser()
					.setSigningKey("jccallo@outlook.com")
					.parseClaimsJws(token.replace("Bearer ", ""))
					.getBody()
					.getSubject();
			return user != null ? new UsernamePasswordAuthenticationToken(user, clave) : null;								
		}
		return null;
	}	
}
