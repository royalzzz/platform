package xin.qust.platform.config.login.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import xin.qust.platform.config.login.token.TokenManager;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.ResponseCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TokenLogoutHandler implements LogoutHandler {

    private TokenManager tokenManager;

    public TokenLogoutHandler(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        String token = httpServletRequest.getHeader("token");
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
