package com.dev.OnlineStamp.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig {
	
	private final String[] visitorsUrls = {
    		"/notice/**",
    		"/intro/**",
    		"/information/**",
    		"/event/**",
    		"/contest/**",
    		"/admin/login",
    		"/front/**",
    		"/**"
    		};
    private final String[] adminsUrls = {
    		"/admin/**", 
    		};
    
    @Bean   
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().antMatchers("/resources/**");   
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.httpBasic()
        		.disable()
			.csrf()
				.disable()
			.authorizeRequests()
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()	
	    		.antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
	    		.antMatchers(adminsUrls).hasRole("ADMIN")
	    		.antMatchers(visitorsUrls).permitAll()
	    		.anyRequest()
	    		.authenticated()
    		.and()
	        .formLogin()
				.loginPage("/admin/login")
				.loginProcessingUrl("/admin/loginProcess")
				.defaultSuccessUrl("/admin/index")
			.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/admin/login")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true)
				.permitAll()
			.and()
			.rememberMe()
				.rememberMeParameter("remember")
				.tokenValiditySeconds(86400)
				.alwaysRemember(false);
//				.userDetailsService(userDetailsService);
                
        return http.build();
    }

}
