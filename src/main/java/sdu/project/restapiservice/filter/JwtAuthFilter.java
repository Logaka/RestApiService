package sdu.project.restapiservice.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private static final String SECRET_KEY = "someSecretKey";
    private static final long ACCESS_TOKEN_VALIDITY = 5 * 60 * 60 * 1000; //5 hours

    public String generateAccessToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration((new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY)))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public Boolean validateToken(String token){
        Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
    }
}
