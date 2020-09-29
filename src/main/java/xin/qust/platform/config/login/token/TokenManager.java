package xin.qust.platform.config.login.token;

public interface TokenManager {
    public String createToken(String username);

    public String getUserFromToken(String token);

    public void removeToken(String token);
}
