package it.mbaziekone.book_e_commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http
				.authorizeHttpRequests(auth -> auth
						// .requestMatchers("/").permitAll() if we have to give access to other pages
						.anyRequest()
						.authenticated())
				.formLogin(form -> form
						.loginPage("/loginAdmin")
						.permitAll())
				.build();
	}	
}