package com.insight68.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Web Security Configuration class
 * 
 * @author VSanthosh
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		// Disable CSRF (cross site request forgery)
		httpSecurity.csrf().disable();

		// No session will be created or used by spring security
		// httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Entry points
		httpSecurity.authorizeRequests()//
				.antMatchers("/login", "/", "/signin.jsp", "/forgotpassword.jsp", "/recoverPasswordDeatails",
						"/passwordreset.jsp**", "/passwordreset")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/").permitAll().and().logout()
				.logoutUrl("/logout").invalidateHttpSession(true).logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/");

		// Apply JWT
		httpSecurity.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
	}

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { //return new
	 * BCryptPasswordEncoder(); return NoOpPasswordEncoder.getInstance(); }
	 */

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/plugins/**",
				"/LegalPdfDocuments/**");
	}

	@Bean
	public AuthenticationManager customAuthenticationManager() throws Exception {
		return authenticationManager();
	}
}
