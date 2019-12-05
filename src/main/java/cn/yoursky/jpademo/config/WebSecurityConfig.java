package cn.yoursky.jpademo.config;

import cn.yoursky.jpademo.service.impl.LoginUserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService userService() {
        return new LoginUserServiceImpl();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin()
                .loginPage("/login").failureUrl("/login?error").permitAll().and().logout().permitAll();
    }

}
