package dev.yojanpardo.common.authorization;

import dev.yojanpardo.user.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenService implements JwtToken {

    @Value("${jwt.expirationTimeMins}")
    private long expirationTimeMins;
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Override
    public String createToken(final String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(getExpirationTime())
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public Date getExpirationTime() {
        final long expirationTimeMillis = new Date().getTime() + 1000 * 60 * expirationTimeMins;
        return new Date(expirationTimeMillis);
    }

    @Override
    public String getUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String jwt, User user) {
        final String userName = getUsername(jwt);
        return (userName.equals(user.getUsername())) && !isTokenExpired(jwt);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClaims(token);
        return claimsResolvers.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
