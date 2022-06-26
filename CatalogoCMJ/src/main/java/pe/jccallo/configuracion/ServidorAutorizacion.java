package pe.jccallo.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@SuppressWarnings("deprecation")
@Configuration
@EnableAuthorizationServer
public class ServidorAutorizacion extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {		
		clients.inMemory()
		.withClient("administrador")
		.secret(passwordEncoder().encode("123456"))
		.authorizedGrantTypes("password","authorization_code","refresh_token","implicit")
		.scopes("read","write")
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(4000);		
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {	
		endpoints.tokenStore(tokenStore)
		.authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {	
		super.configure(security);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
