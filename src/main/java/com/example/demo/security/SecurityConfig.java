package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(this.datasource)
		.usersByUsernameQuery("select username, password, enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, authority from authorities where username=?")
		.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/* Expicacion del codigo:
		 * 
		 *  Cuando se realize una peticion a /design /orders el usuario debera tener el role ROLE_USER
		 *  si el usuario tiene el role ROLE_USER entonces dale acceso cualquier enpoint  " /, /** "
		 * 	para autenticar al usuario usa el formulario por defecto
		 *	realiza logout cuando se apunte al enpoint /login?logout y redirecciona a "/"
		 * 
		 * */
		
		http
		.authorizeRequests() 
		.antMatchers("/design", "/orders") 
		.hasRole("USER") 
		.antMatchers("/", "/**").permitAll()
		.and().formLogin()
		.and().logout().logoutSuccessUrl("/");
		//.and().csrf().disable();
		
		/* Notas:
		 * 
		 * spring agrega el sufijo ROLE_ por lo que es importante que 
		 * los registros de la tabla de permisos tengan el sufijo ROLE_
		 * 
		 * si no se usa <input type="hidden" name="_csrf" th:value="${_csrf.token}"/> 
		 * se debe desabilitar el csrf (cross-site request forgery)
		 * 
		 * */
		

	}
}
