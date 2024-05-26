package by.nexer.travelassistant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/", "/oauth2/**", "/login/**").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login()
                .and()
                .logout()
                .logoutSuccessHandler(keycloakLogoutSuccessHandler());
        return http.build();
    }

    @Bean
    public LogoutSuccessHandler keycloakLogoutSuccessHandler() {
        return (request, response, authentication) -> {
            String logoutUri = "http://localhost:8180/auth/realms/external/protocol/openid-connect/logout";
            response.sendRedirect(logoutUri);
        };
    }
}
