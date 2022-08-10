package se.lexicon.springbootthymeleafproject.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
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
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .authorizeHttpRequests()
                .antMatchers("/webjars/**", "/login", "/images/**", "/js/**", "/authenticate").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticate")
                .defaultSuccessUrl("/dashboard");

        return http.build();
    }


   @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails guest = User.withDefaultPasswordEncoder()
                .username("guest@test.se").password("guest").roles("GUEST").build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user").password("user").roles("GUEST", "USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin").password("admin").roles("GUEST", "USER", "ADMIN").build();

        return new InMemoryUserDetailsManager(guest, user, admin);
    }

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    public void globalConfiguration(AuthenticationManager auth){
        auth.userDetailsService(customUserDetailsService).
    }


}