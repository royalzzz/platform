package xin.qust.platform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import xin.qust.platform.config.login.LoginMethodConfig;
import xin.qust.platform.config.login.filter.EmailLoginFilter;
import xin.qust.platform.config.login.provider.EmailLoginProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginMethodConfig loginMethodConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout().logoutUrl("/logout")
                .and().authorizeRequests().antMatchers("/loginByEmail", "/loginByUserName").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterBefore(loginMethodConfig.emailLoginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(loginMethodConfig.userNameLoginFilter(), EmailLoginFilter.class)
                .csrf().disable();
    }
}
