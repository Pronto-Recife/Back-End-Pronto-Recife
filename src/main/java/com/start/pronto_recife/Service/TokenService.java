package com.start.pronto_recife.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenService {
    @Value("${jjwt.secret}")
    private String jjwtSecret;

    public String generateToken(String id){
        return Jwts.builder()
                .subject(id)
                .issuedAt(new Date())
                .expiration(Date.from(Instant.now().plus(24, ChronoUnit.HOURS)))
                .signWith(getSecretKey())
                .compact();
    }
    private SecretKey getSecretKey() {
        return new SecretKeySpec(jjwtSecret.getBytes(), "HmacSHA256");
    }
    public String validateToken(String token){
        Algorithm algorithm = encryptor(jjwtSecret);
        try {
            return JWT.require(algorithm)
                    .build()
                    .verify(token).getToken();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public Algorithm encryptor(String jjwtSecret){
        return Algorithm.HMAC256(jjwtSecret);
    }
    public String getEmailFromToken(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getSubject();
    }
}
