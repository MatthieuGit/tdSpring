package com.example.tdspring.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource            dataSource;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery(
                "select username as username,password as credential, id from app_user where username=?")
            .authoritiesByUsernameQuery(
                "select app_user_id as principal , roles_id as role from app_user_roles "
                    + " INNER JOIN app_user ON app_user_roles.app_user_id = app_user.id "
                    + " where app_user.username=?")
            .passwordEncoder(bCryptPasswordEncoder).rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.formLogin();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/login/**","register/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/articles/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/contenu/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/articles/**").hasRole("EDITEUR");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/contenu/**").hasRole("EDITEUR");
        http.authorizeRequests().anyRequest().authenticated();

    }


}
