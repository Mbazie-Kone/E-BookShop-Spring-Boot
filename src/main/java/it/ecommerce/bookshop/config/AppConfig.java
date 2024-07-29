package it.ecommerce.bookshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		/**
		 * Configuration to deny all the requests
		 */
		http.authorizeHttpRequests(
				requests -> requests.anyRequest().denyAll()
				).formLogin(Customizer.withDefaults());
		
		return http.build();
	}
	
	/*
	 * @Bean SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
	 * throws Exception { http.authorizeHttpRequests((requests) -> requests
	 * .requestMatchers("/").permitAll() .anyRequest().authenticated())
	 * .formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
	 * 
	 * return http.build(); }
	 */
}
