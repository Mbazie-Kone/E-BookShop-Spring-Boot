package it.mbaziekone.book_e_commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").loginProcessingUrl("/perform_login")
						.defaultSuccessUrl("/admin", true).failureUrl("/login?error=true"))
				.logout(logout -> logout.logoutUrl("/perform_logout").deleteCookies("JSESSIONID")
						.logoutSuccessUrl("/login?logout=true"));

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