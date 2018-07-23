package com.ke.auth.config;

import com.ke.auth.security.CustomPasswordEncoder;
import com.ke.auth.security.DomainUserAuthenticationProvider;
import com.ke.auth.security.DomainUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;


@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	private final DomainUserDetailsService userDetailsService;

	@Autowired
	private DomainUserAuthenticationProvider provider;

	@Autowired
	public WebSecurityConfiguration(DomainUserDetailsService userDetailsService){
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public CustomPasswordEncoder customPasswordEncoder(){
		return new CustomPasswordEncoder();
	}

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new CustomPasswordEncoder());
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}
}
