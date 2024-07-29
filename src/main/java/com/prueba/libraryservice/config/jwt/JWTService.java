package com.prueba.libraryservice.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTService {

    private static final String SECRET_KEY = "A5A52SAS450F02304HDSVYUEF0239UR843JHSDVCUYASEFGW7";

    public static String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public static boolean isTokenValid(String token, UserDetails userDetails) {

        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private static Claims getAllClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(getKey())
                .parseClaimsJws(token)
                .getBody();
    }

    public static <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String getToken(UserDetails user){

        return  getToken(new HashMap<>(),user);

    }
    private static Date getExpiration(String token){
        return getClaim(token, Claims::getExpiration);
    }

    private static boolean isTokenExpired(String token){
        return  getExpiration(token).before(new Date());
    }
    Date currentDate = new Date();
    long expirationTime = currentDate.getTime() + (1000 * 60 * 60 * 24);
    private String getToken(Map<String, Object> extraClaims, UserDetails user){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(expirationTime))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private static Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
