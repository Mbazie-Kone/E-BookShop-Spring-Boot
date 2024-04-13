package it.ecommerce.bookshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import it.ecommerce.bookshop.service.impl.UserSecurityServiceImpl;
import it.ecommerce.bookshop.utility.SecurityUtility;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private Environment env;

	@Autowired
	private UserSecurityServiceImpl userSecurityServiceImpl;

	private static final String[] PUBLIC_MATCHERS = {

			"/css/**", 
			"/js/**", 
			"/image/**", 
			"/", 
			"/newUser", 
			"/forgetPassword", 
			"/login", "/fonts/**", 
			"/bookshelf",
			"/bookDetail", 
			"/faq", 
			"/searchByCategory", 
			"/searchBook"

	};

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {

		return (web) -> web.ignoring().antMatchers(PUBLIC_MATCHERS);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic(withDefaults());
		return http.build();
	}

	}

	private BCryptPasswordEncoder passwordEncoder() {

		return SecurityUtility.passwordEncoder();
	}

}
