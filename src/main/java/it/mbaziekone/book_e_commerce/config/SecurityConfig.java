package it.mbaziekone.book_e_commerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
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
						.defaultSuccessUrl("/dashboard",true)
						.failureUrl("/loginAdmin?error=true")
						.permitAll())
				.logout(logout -> logout
						.logoutUrl("/perform_logout")
						.logoutSuccessUrl("/loginAdmin?logout=true")
						.deleteCookies("JSESSIONID")
						.invalidateHttpSession(true)
						.permitAll()
				)
				.build();
	}
	
	@Bean
	UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		
		UserDetails user = User.builder()
				.username("admin")
				.password(passwordEncoder.encode("1234"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}