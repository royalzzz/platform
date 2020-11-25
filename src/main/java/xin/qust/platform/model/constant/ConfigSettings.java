package xin.qust.platform.model.constant;

public class ConfigSettings {

    public static final int A_SECOND = 1000;
    public static final int A_MINUTE = 60 * A_SECOND;
    public static final int AN_HOUR = 60 * A_MINUTE;
    public static final int A_DAY = 24 * AN_HOUR;
    public static final int TOKEN_EXPIRED_TIME = A_DAY;

    public static final String TOKEN_SIGN_KEY = "123456";

    public static final String ELASTIC_SEARCH_HOSTNAME = "localhost";
    public static final int ELASTIC_SEARCH_PORT = 9200;
    public static final String ELASTIC_SEARCH_SCHEME = "http";
}
