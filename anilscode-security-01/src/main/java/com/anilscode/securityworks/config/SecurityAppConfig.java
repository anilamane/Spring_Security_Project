package com.anilscode.securityworks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.*;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityAppConfig {
	
	@Autowired
	HttpSecurity httpSecurity;
	
	
	@Bean
	public InMemoryUserDetailsManager setUpUsers() {
		
		UserDetails karnaUser = 
				User
				.withUsername("karna")
				.password("$2a$10$TfhGhfTD4kuwVWKsqXIbKehukq1Mk7pikEaCxt91Iz3dYW3tEuGqO")
				.roles("admin","user")
				.build();
		
		UserDetails eklavvyaUser = User.withUsername("eklavvya")
			.password("$2a$10$ffEqiDbmmXQCifWUq0LpiOgDCHXptuBaDMTvRVV.PsdmAdWVkuXqG")
			.roles("user")
			.build();
		
		/*InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(karnaUser);
		inMemoryUserDetailsManager.createUser(eklavvyaUser);
		
		return inMemoryUserDetailsManager;*/		
		return new InMemoryUserDetailsManager(karnaUser,eklavvyaUser);
		
	}
	
	
	
	@Bean
	SecurityFilterChain settingUpHttpSecurity() throws Exception{
		
		
		//hi request should be authenticated 
		//bye request should be permited by all
		//hello it is denyed by all
		
		//httpSecurity.authorizeHttpRequests().requestMatchers("/hi","/hello").authenticated();
		//httpSecurity.authorizeHttpRequests().requestMatchers(AntPathRequestMatcher.antMatcher("/hi"),AntPathRequestMatcher.antMatcher("/hello")).authenticated();
		//httpSecurity.authorizeHttpRequests().requestMatchers("/bye").permitAll();
		httpSecurity.authorizeHttpRequests().requestMatchers(antMatcher("/hi"),antMatcher("/hello")).authenticated();
		httpSecurity.authorizeHttpRequests().requestMatchers(antMatcher("/bye")).permitAll();
		//httpSecurity.authorizeHttpRequests().requestMatchers("/hello").authenticated();
		
		httpSecurity.authorizeHttpRequests(customizer-> {
				// TODO Auto-generated method stub
				customizer.requestMatchers("/hi").permitAll();
				customizer.anyRequest().authenticated();	
		});
		
		/*httpSecurity.authorizeHttpRequests(customizer->{
			customizer.requestMatchers(antMatcher("/hi"),antMatcher("/hello")).authenticated();
			customizer.requestMatchers(antMatcher("/bye")).permitAll();
		});*/
		
		//httpSecurity.authorizeHttpRequests().anyRequest().denyAll();
		httpSecurity.formLogin();
		httpSecurity.httpBasic();
		return httpSecurity.build(); 
	}
	
	
	
	//mvcHandlerMappingIntrospector
	/*@Bean(name="mvcHandlerMappingIntrospector")
	HandlerMappingIntrospector handlerMappingIntrospector() {
		return new HandlerMappingIntrospector();
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	/*
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/*@Bean
	public InMemoryUserDetailsManager setUpUser() {

		ArrayList<GrantedAuthority> authoritiesList = new ArrayList<>();
		//ArrayList<GrantedAuthority> authoritiesList1 = new ArrayList<>();

		authoritiesList.add(new SimpleGrantedAuthority("admin"));
		authoritiesList.add(new SimpleGrantedAuthority("user"));
		authoritiesList.add(new SimpleGrantedAuthority("visitor"));
		authoritiesList.add(new SimpleGrantedAuthority("subscriber"));

		//authoritiesList1.add(new SimpleGrantedAuthority("visitor"));
		//authoritiesList1.add(new SimpleGrantedAuthority("subscriber"));

		UserDetails kichhaUser = new User("kichha", "kichha", authoritiesList);
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(kichhaUser);

		
		UserDetails karnaUser = new User("karna","karna",authoritiesList);
		InMemoryUserDetailsManager inMemoryUserDetailsManager1 = new
		InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(karnaUser);
		 

		return inMemoryUserDetailsManager;
	}

	/*
	 * 
	 * @Bean public InMemoryUserDetailsManager setUpKarnaUser() {
	 * 
	 * //ArrayList<GrantedAuthority> authoritiesList = new ArrayList<>();
	 * 
	 * ArrayList<GrantedAuthority> authoritiesList1 = new ArrayList<>();
	 * 
	 * //authoritiesList.add(new SimpleGrantedAuthority("admin"));
	 * //authoritiesList.add(new SimpleGrantedAuthority("user"));
	 * 
	 * authoritiesList1.add(new SimpleGrantedAuthority("visitor"));
	 * authoritiesList1.add(new SimpleGrantedAuthority("subscriber"));
	 * 
	 * 
	 * 
	 * UserDetails kichhaUser = new User("kichha","kichha",authoritiesList);
	 * InMemoryUserDetailsManager inMemoryUserDetailsManager = new
	 * InMemoryUserDetailsManager();
	 * inMemoryUserDetailsManager.createUser(kichhaUser);
	 * 
	 * 
	 * UserDetails karnaUser = new User("karna","karna",authoritiesList1);
	 * InMemoryUserDetailsManager inMemoryUserDetailsManager1 = new
	 * InMemoryUserDetailsManager();
	 * inMemoryUserDetailsManager1.createUser(karnaUser); return
	 * inMemoryUserDetailsManager1;
	 * 
	 * }
	 */

	/*
	 * InMemoryUserDetailsManager setUpKarnaUser() {
	 * 
	 * }
	 */
	/*@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/
}