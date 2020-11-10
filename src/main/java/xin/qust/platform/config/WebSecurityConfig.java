package xin.qust.platform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import xin.qust.platform.config.login.LoginMethodConfig;
import xin.qust.platform.config.login.filter.TokenAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginMethodConfig loginMethodConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout().logoutUrl("/logout")
                .addLogoutHandler(loginMethodConfig.tokenLogoutHandler())
                .and().authorizeRequests().antMatchers("/loginByEmail", "/loginByUserName", "/user/register").permitAll()
                .and().authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilterBefore(loginMethodConfig.tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(loginMethodConfig.emailLoginFilter(), TokenAuthenticationFilter.class)
                .addFilterAfter(loginMethodConfig.userNameLoginFilter(), TokenAuthenticationFilter.class)
                .csrf().disable();
    }
}
