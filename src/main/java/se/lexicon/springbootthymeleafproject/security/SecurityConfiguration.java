package se.lexicon.springbootthymeleafproject.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests().antMatchers("/webjars/**","/login").permitAll().anyRequest().authenticated();
        httpSecurity.formLogin();

        return httpSecurity.build();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails guest = User.withDefaultPasswordEncoder().username("guest").password("guest").roles("GUEST").build();
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("user").roles("GUEST","USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("GUEST","USER","ADMIN").build();
        return new InMemoryUserDetailsManager(guest,user,admin);
    }

}
