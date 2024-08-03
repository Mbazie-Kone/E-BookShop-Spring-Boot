package it.mbaziekone.book_e_commerce.config;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) ->
			requests.requestMatchers("/public/**", "/login", "/error").permitAll()
			.anyRequest().authenticated()).formLogin().loginPage("/loginAdmin.html").defaultSuccessUrl("perform_login", true)
			.failureUrl("/login?error=true")
			
			return http.build();
	}

	/*
	 * @Bean SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
	 * throws Exception {
	 *//**
		 * Configuration to permit all the requests
		 *//*
			 * http.authorizeHttpRequests(requests ->
			 * requests.anyRequest().permitAll()).formLogin(Customizer.withDefaults())
			 * .httpBasic(Customizer.withDefaults());
			 * 
			 * return http.build(); }
			 */

	/*
	 * @Bean SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
	 * throws Exception {
	 * 
	 * http.authorizeHttpRequests(( requests ) -> requests
	 * .anyRequest().authenticated() ).formLogin(Customizer.withDefaults())
	 * .httpBasic(Customizer.withDefaults());
	 * 
	 * return http.build(); }
	 */
}