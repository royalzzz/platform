package xin.qust.platform.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ElasticSearchConfig {

    private static final String hostName = "localhost";
    private static final int port = 9200;
    private static final String scheme = "http";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final ElasticSearchConfig elasticSearchConfig = new ElasticSearchConfig();

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        logger.info(hostName + ":" + port + " [" + scheme +"] starting...");
        return new RestHighLevelClient(RestClient.builder(new HttpHost(hostName, port, scheme)));
    }

    public void close() {
        try {
            restHighLevelClient().close();
            logger.info(hostName + ":" + port + " [" + scheme +"] closed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
