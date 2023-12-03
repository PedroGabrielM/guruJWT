package br.com.project.frontendspring.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.support.SessionFlashMapManager;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/account/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/account/login")
                .usernameParameter("email")
                .loginProcessingUrl("/")
                .failureHandler((request, response, exception) -> {
                    final FlashMap flashMap = new FlashMap();
                    flashMap.put("loginErrorMessage", "Nome de usuario e/ou senha invalido");

                    final FlashMapManager flashMapManager = new SessionFlashMapManager();
                    flashMapManager.saveOutputFlashMap(flashMap, request, response);

                    response.sendRedirect("/account/login");
                })
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}
