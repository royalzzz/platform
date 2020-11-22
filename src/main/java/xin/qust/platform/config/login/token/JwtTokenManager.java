package xin.qust.platform.config.login.token;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenManager implements TokenManager {

//    @Value("${token.expire}")
    private final long tokenExpiration = 12 * 60 * 60 * 1000;
    private final String tokenSignKey = "123456";

    @Override
    public String createToken(String username) {
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey).compressWith(CompressionCodecs.GZIP).compact();
    }

    @Override
    public String getUserFromToken(String token) {
        return Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token).getBody().getSubject();
    }

    @Override
    public void removeToken(String token) {
        // 无需删除，客户端扔掉即可
    }
}
