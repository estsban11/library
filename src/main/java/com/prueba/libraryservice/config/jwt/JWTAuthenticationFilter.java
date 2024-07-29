package com.prueba.libraryservice.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prueba.libraryservice.domain.commons.Response.Response;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private  final  JWTService jwtService;
    private final UserDetailsService userDetailsService;

    public JWTAuthenticationFilter(JWTService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String token = getTokenFromRequest(request);
        final String username;

        if(token==null){
            filterChain.doFilter(request,response);
             return;
        }

      try{
          username = JWTService.getUsernameFromToken(token);

          if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
              UserDetails userDetails = userDetailsService.loadUserByUsername(username);
              if(JWTService.isTokenValid(token,userDetails)){
                  UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                          userDetails,null,userDetails.getAuthorities()
                  );
                  authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                  SecurityContextHolder.getContext().setAuthentication(authToken);
              }
          }

          filterChain.doFilter(request,response);
      }catch (ExpiredJwtException exception){
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
          Response<String> customError = new Response<>("Token expired",401,null);
          ObjectMapper objectMapper = new ObjectMapper();
          String jsonError = objectMapper.writeValueAsString(customError);
        response.getWriter().write(jsonError);
      }

    }

    private String getTokenFromRequest(HttpServletRequest request) {

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer")){
            return authHeader.substring(7);
        }
        return  null;
    }
}
