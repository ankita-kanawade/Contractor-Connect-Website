package br.com.carlosjunior.registrationlogin.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.carlosjunior.registrationlogin.services.UserService;

@Configuration
@EnableWebSecurity
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	/*~~(Migrate manually based on https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)~~>*/@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authenticationProvider());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests(requests -> requests.antMatchers(
				"/userregistration**",
				"/admin-login",
				"/admin-dashboard",
				"/gallary",
				"/success",
				"/contractor/**",
				"/project/**",
				"/userproject/**",
				"/contractoruser/**",
				"/js/**",
				"/css/**",
				"/images/**").permitAll()
				.anyRequest().authenticated())
		
		.formLogin(login -> login
				.loginPage("/userlogin").defaultSuccessUrl("/MainFile")
				.permitAll())
		.logout(logout -> logout
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/userlogin?logout")
				.permitAll());
	}

}
