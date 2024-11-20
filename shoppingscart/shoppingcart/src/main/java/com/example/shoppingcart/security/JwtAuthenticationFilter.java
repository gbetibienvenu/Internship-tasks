package com.example.shoppingcart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String token = getJwtFromRequest(request);  // Get the JWT from the request header

        if (token != null && jwtTokenProvider.validateToken(token)) {
            String username = jwtTokenProvider.getUsernameFromJwt(token);  // Extract username from token
            var userDetails = userDetailsService.loadUserByUsername(username);  // Load user details
            var auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());  // Create authentication token
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));  // Set the details for authentication
            SecurityContextHolder.getContext().setAuthentication(auth);  // Set the authentication object in the context
        }

        chain.doFilter(request, response);  // Continue with the request
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);  // Extract token without "Bearer " prefix
        }
        return null;
    }
}