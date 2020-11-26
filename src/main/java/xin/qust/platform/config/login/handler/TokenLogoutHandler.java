package xin.qust.platform.config.login.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import xin.qust.platform.config.login.plugins.jwt.TokenManager;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.constant.ResponseCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TokenLogoutHandler implements LogoutHandler {

    private TokenManager tokenManager;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public TokenLogoutHandler(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        String token = httpServletRequest.getHeader("token");
        logger.info(token);
        if (token != null) {
            tokenManager.removeToken(token);
        }
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            PrintWriter writer = httpServletResponse.getWriter();
            Message message = new Message();
            message.setResponseCode(ResponseCode.USER_NOT_LOGGED_IN);
            writer.write(message.toJsonString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
