package be.ss13security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // load userdetailservice do mình xây dựng để spring auth
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Đăng ký những pattern không cần đăng nhập
        http.authorizeRequests().antMatchers("/", "/login").permitAll();

        // Đăng ký những pattern phải login với quyền admin mới được truy cập
        http.authorizeRequests().antMatchers("/userApps/addRole").hasRole("ADMIN");

        // Đăng ký những pattern phải login với quyền user hoặc admin mới được truy cập
        http.authorizeRequests().antMatchers("/userApps/create").
                access("hasAnyRole('ROLE_ADMIN','ROLE_SALE','ROLE_PURCHASE')");

        // Trả về url nào khi user không có quyền truy cập
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/deny");

        // Trường hợp user chưa đăng nhập truy cập những pattern cần quyền thì phải chuyển sang trang login
        http.authorizeRequests().and().formLogin();
    }
}
