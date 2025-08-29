package src.saveeatback.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private long expiration;

    public String generateToken(Authentication authentication) {
        UserDetailsImpl userPrinciple = (UserDetailsImpl) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        return JWT.create()
                .withSubject(userPrinciple.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(expiryDate)
                .withClaim("roles", userPrinciple.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).toList())
                .sign(algorithm);
    }

    public String getUsernameFromToken(String token) {
        return JWT.decode(token).getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
            JWT.require(algorithm).build().verify(token);
            return true;
        }catch (JWTVerificationException exception){
            log.warn("JWT invalid {}", exception.getMessage());
        }
        return false;
    }
}
