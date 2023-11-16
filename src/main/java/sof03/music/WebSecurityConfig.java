package sof03.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import sof03.music.web.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

        @Autowired
        private UserDetailsServiceImpl userDetailsService;

        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {

                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(antMatcher("/css/**")).permitAll()
                                                .requestMatchers(antMatcher("/signup")).anonymous()
                                                .requestMatchers(antMatcher("/saveuser")).anonymous()
                                                .requestMatchers(antMatcher("/bandlist")).permitAll()
                                                .requestMatchers(antMatcher("/bandinfo/**")).permitAll()
                                                .requestMatchers(toH2Console()).permitAll()
                                                .anyRequest().authenticated())
                                .csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()))
                                .headers(headers -> headers
                                                .frameOptions(frameOptions -> frameOptions
                                                                .disable()))
                                .formLogin(formLogin -> formLogin
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/bandlist", true)
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutSuccessUrl("/bandlist")
                                                .permitAll());

                return http.build();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }
}
