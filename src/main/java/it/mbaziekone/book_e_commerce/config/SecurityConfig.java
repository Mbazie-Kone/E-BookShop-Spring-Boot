package it.mbaziekone.book_e_commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		/**
		 * Configuration to permit all the requests
		 */
		http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll()).formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}
}