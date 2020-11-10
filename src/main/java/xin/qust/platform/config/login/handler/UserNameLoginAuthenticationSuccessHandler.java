package xin.qust.platform.config.login.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import xin.qust.platform.config.login.token.TokenManager;
import xin.qust.platform.domain.UserNameLogin;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.ResponseCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserNameLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private TokenManager tokenManager;

    public UserNameLoginAuthenticationSuccessHandler(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        UserNameLogin user = (UserNameLogin) authentication.getPrincipal();
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter writer = httpServletResponse.getWriter();
        Message message = new Message();
        message.setResponseCode(ResponseCode.SUCCESS);
        message.setToken(tokenManager.createToken(user.getUsername()));
        writer.write(message.toJsonString());
        logger.info(message.toJsonString());
    }

}
