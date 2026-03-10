package com.workshop.config.security;

import com.workshop.config.security.component.Http401UnauthorizedEntryPoint;
import com.workshop.config.security.component.JwtAuthenticationProvider;
import com.workshop.config.security.component.JwtTokenSettings;
import com.workshop.config.security.component.filters.JwtAuthorizationFilter;
import com.workshop.config.security.component.filters.JwtUsernamePasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtTokenSettings jwtTokenSettings;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final Http401UnauthorizedEntryPoint authEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManager authManager = new ProviderManager(jwtAuthenticationProvider);

        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .addFilter(new JwtUsernamePasswordAuthenticationFilter(authManager))
                .addFilter(new JwtAuthorizationFilter(authManager, jwtTokenSettings))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/authentication/login").permitAll()
                        .requestMatchers("/user/register").permitAll()
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/bicycles/**").hasAnyRole("ADMIN")
                        .requestMatchers("/system/health").hasAnyRole("EMPLOYEE")
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login.permitAll())
                .logout(logout -> logout.permitAll())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(ex -> ex.authenticationEntryPoint(authEntryPoint));

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(
                        "/webjars/springfox-swagger-ui/**",
                        "/swagger-ui.html/**",
                        "/swagger-resources/**",
                        "/css/**"
                );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new DelegatingPasswordEncoder("bcrypt", Map.of("bcrypt", new BCryptPasswordEncoder()));
    }
}
