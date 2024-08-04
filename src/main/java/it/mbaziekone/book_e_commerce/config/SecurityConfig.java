package it.mbaziekone.book_e_commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/public/**", "/login", "/error").permitAll()
						.anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/loginAdmin")
						.loginProcessingUrl("/perform_login")
						.defaultSuccessUrl("/",true)
						.failureUrl("/login?error=true")
						.permitAll())
				.logout(logout -> logout
						.logoutUrl("perform_logout")
						.logoutSuccessUrl("/login?logout=true")
						.deleteCookies("JSESSIONID")
						.invalidateHttpSession(true)
						.permitAll()
				)
				.build();
	}	
}