package com.example.bankapp.security.config;

import com.example.bankapp.security.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // аннотация для WebSecurity модуля Spring Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtFilter jwtFilter;

//    @Bean
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//       return
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html/**", "/users/register/**", "/users/auth/**", "/h2-console/**").permitAll()
                .antMatchers("/accounts/**","/users/**","/transactions/**").hasRole("USER")
//                .antMatchers(HttpMethod.GET).hasRole("USER")
                .antMatchers("/**").hasRole("ADMIN")
                .anyRequest().authenticated() // любой запрос требует авторизации
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//                .build();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    public void configure(WebSecurity web) {

        web.ignoring().antMatchers("/h2-console/**");
    }
}