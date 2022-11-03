package com.iu.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	WebSecurityCustomizer webSecurityConfig() {
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/js/**")
				.antMatchers("/css/**")
				.antMatchers("/favicon/**")
				.antMatchers("/resources/**");
				
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception {
		httpSecurity
			.cors()
			.and()
			.csrf()
			.disable()
			.authorizeHttpRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/manager").hasRole("MANAGER")
			.antMatchers("/qna/list").permitAll()
			.antMatchers("/qna/**").hasRole("MEMBER")
			
			.anyRequest().permitAll()
			.and()
			
			.formLogin()
			.loginPage("/member/login")
			.passwordParameter("password")
			.usernameParameter("id")
			.defaultSuccessUrl("/")
			.failureUrl("/member/login")
			.permitAll()
			.and()
			
			.logout()
			.logoutUrl("/member/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.permitAll();
		
		return httpSecurity.build();
			
	}
	
	@Bean
	public PasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder();
	}

}
