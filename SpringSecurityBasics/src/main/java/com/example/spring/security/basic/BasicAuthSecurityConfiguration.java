package com.example.spring.security.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthSecurityConfiguration {
	
	@SuppressWarnings("removal")
	@Bean
	SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		//http.formLogin(withDefaults());
		http.sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				);
		http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.headers().frameOptions().sameOrigin();
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		
		var user = User.withUsername("in28minutes")
				    .password("{noop}dummy")
				    .roles("USER")
				    .build();
		
		var admin = User.withUsername("admin")
			    .password("{noop}dummy")
			    .roles("ADMIN")
			    .build();
		
		return new InMemoryUserDetailsManager(user,admin);
		
	}
}
