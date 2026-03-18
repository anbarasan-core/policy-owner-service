package com.alturion.policyowner.config;

import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Component
public class JWTUtil {
	
	private final long EXPIRATION_TIME = 1000*60*20;
	
	private final String SECRET = "alturionSecretKeyUsedForBestSecurity2112";
	
	Key signKey = Keys.hmacShaKeyFor(SECRET.getBytes());
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
				.signWith(signKey, SignatureAlgorithm.HS256)
				.compact();
		}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(signKey)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public <T> T extractClaim(String token,Function<Claims,T> claimsResolver) {
		
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}
	
	public boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public boolean validateToken(String token,String username) {
		final String extractedUserName = extractUsername(token);
		return (extractedUserName.equals(extractedUserName) 
				&& !isTokenExpired(token));
	}
}
