package com.workshop.config.security.component.filters;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.workshop.config.security.component.JwtTokenConfig;
import com.workshop.config.security.component.JwtTokenSettings;
import com.workshop.config.security.component.UserAuthentication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private final JwtTokenSettings jwtTokenSettings;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager,
                                  JwtTokenSettings jwtTokenSettings) {
        super(authenticationManager);
        this.jwtTokenSettings = jwtTokenSettings;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        final String token = getToken(request);
//        final PreAuthenticatedAuthenticationToken preAuthentication = getAuthentication(token);
//        final Authentication authentication = getAuthenticationManager().authenticate(preAuthentication);
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        final Authentication mockAuthentication = UserAuthentication.builder()
                .userId(1L)
                .userName("mockUser")
                .isAuthenticated(true)
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_ADMIN")))
                .build();
        SecurityContextHolder.getContext().setAuthentication(mockAuthentication);

        chain.doFilter(request, response);
    }

    private PreAuthenticatedAuthenticationToken getAuthentication(String header) {
        final DecodedJWT token = JWT.require(JwtTokenConfig.getJwtSignAlgorithm(jwtTokenSettings.getSecret()))
                .build()
                .verify(header.replace(JwtTokenConfig.TOKEN_PREFIX, ""));

        if (!org.springframework.util.StringUtils.hasText(token.getSubject())) {
            throw new BadCredentialsException("Illegal token with empty user name");
        }
        return new PreAuthenticatedAuthenticationToken(token.getSubject(), token.getToken());
    }

    private String getToken(HttpServletRequest request) {
        final String tokenHeader = request.getHeader("token");
        final Cookie[] cookies = request.getCookies();


        return tokenHeader;
    }
}
