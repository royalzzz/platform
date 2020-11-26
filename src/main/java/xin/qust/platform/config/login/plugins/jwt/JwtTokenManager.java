package xin.qust.platform.config.login.plugins.jwt;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

import static xin.qust.platform.model.constant.ConfigSettings.TOKEN_EXPIRED_TIME;
import static xin.qust.platform.model.constant.ConfigSettings.TOKEN_SIGN_KEY;

@Component
public class JwtTokenManager implements TokenManager {

    @Override
    public String createToken(String username) {
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRED_TIME))
                .signWith(SignatureAlgorithm.HS512, TOKEN_SIGN_KEY).compressWith(CompressionCodecs.GZIP).compact();
    }

    @Override
    public String getUserFromToken(String token) {
        return Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    @Override
    public void removeToken(String token) {
        Jwts.parser().setSigningKey(TOKEN_SIGN_KEY).parseClaimsJws(token).getBody().setExpiration(new Date());
    }
}
