package com.olive.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true,proxyTargetClass=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	/*@Autowired
	UserDetailsService userDetailsService;*/
	
	
	/*@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		
		security.authorizeRequests().antMatchers("/resources/**","/login").permitAll().anyRequest().authenticated().and()
		        .formLogin().loginPage("/login").defaultSuccessUrl("/home")
		        .failureUrl("/login?error").and()
		        
		        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).deleteCookies("JSESSIONID")
		        .permitAll().and().exceptionHandling().accessDeniedPage("/errorpage").and()
		        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
		        .sessionFixation().migrateSession();
		//security.csrf().disable();
		
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Niteesh").password("$2a$10$p3PHnpoBAnzZiL8mr3gMieMhVVSb585ajC2ZsBB0kwb4KvZKFSdNi").roles("ADMIN")
       .and() .withUser("Nagendra").password("$2a$10$p3PHnpoBAnzZiL8mr3gMieMhVVSb585ajC2ZsBB0kwb4KvZKFSdNi").roles("ADMIN");
      //  	.userDetailsService(userDetailsService)
       // 	.passwordEncoder(passwordEncoder());
      //  .authenticationProvider(this.CAP);
    }
	
	 @Bean
	    public HttpSessionEventPublisher httpSessionEventPublisher() {
	        return new HttpSessionEventPublisher();
	    }

}
