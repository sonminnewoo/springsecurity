package com.example.demo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public  BCryptPasswordEncoder  encodePwd() {
		return new  BCryptPasswordEncoder();
	}
	@Bean
	public  SecurityFilterChain fileChain(HttpSecurity http) throws Exception{
		  http.csrf(csrf -> csrf.disable())
          .authorizeHttpRequests(request -> request
                    .requestMatchers("/user/*").authenticated()
                  .anyRequest().permitAll()
          )
          .formLogin(login -> login
        		  .loginPage("/login")
        		  .loginProcessingUrl("/loginPro")
//        		  .usernameParameter("userid")
//        		  .passwordParameter("pw")
        		  .defaultSuccessUrl("/")    
          );
		return http.build();
	}
	
	
	
//	@Bean
//	public SecurityFilterChain fileChain(HttpSecurity http) throws Exception{
//		http.csrf().disable()
//					.authorizeHttpRequests()
//					.requestMatchers("/user/*").authenticated()
//					.anyRequest()
//					.permitAll()
//		.and()
//				 .formLogin()
//			      .loginPage("/login")
//			      .loginProcessingUrl("/loginPro")
//			      .defaultSuccessUrl("/")
//	  .and()
//		       .logout()
//		       .logoutUrl("/logout")
//		       .logoutSuccessUrl("/")
//		       .invalidateHttpSession(true);
//		return http.build();
//		
//	}

}
