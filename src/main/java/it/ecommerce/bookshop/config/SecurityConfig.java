package it.ecommerce.bookshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import it.ecommerce.bookshop.service.impl.UserSecurityService;
import it.ecommerce.bookshop.utility.SecurityUtility;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig {

	@Autowired
	private Environment env;

	@Autowired
	private UserSecurityService userSecurityService;

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
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated());
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
                .formLogin(login -> login.failureUrl("/login?error")
                        .loginPage("/login").permitAll())
                .logout(logout -> {
					try {
                        logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
		return http.build();
	}

	private BCryptPasswordEncoder passwordEncoder() {

		return SecurityUtility.passwordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
	}
}
