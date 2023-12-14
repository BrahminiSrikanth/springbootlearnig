package com.example.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.spring.security.service.EmployeeUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class EmployeeSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder pwdEncoder){
		/*UserDetails hr=User.withUsername("Srikanth")
				             .password(pwdEncoder.encode("pwd1"))
				             .roles("HR").build();
		UserDetails employee=User.withUsername("Brahmini")
	             .password(pwdEncoder.encode("pwd2"))
	             .roles("EMPLOYEE").build();
		UserDetails mangerhr=User.withUsername("Srika")
	             .password(pwdEncoder.encode("pwd3"))
	             .roles("MANAGER","HR").build();
		return new InMemoryUserDetailsManager(hr,employee,mangerhr);*/
		return new EmployeeUserDetailsService();
	}

		
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(auth->auth.requestMatchers("/employees/welcome","/employees/create").permitAll()
		.requestMatchers("/employees/**").authenticated()).httpBasic(Customizer.withDefaults())
		.csrf(csrf -> csrf.disable())
		//.headers(Customizer.withDefaults()).
		.build();
	}
}
