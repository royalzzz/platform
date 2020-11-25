package xin.qust.platform.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static xin.qust.platform.model.constant.ConfigSettings.*;

@Configuration
public class ElasticSearchConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        logger.info("ElasticSearchService Starting...");
        RestClientBuilder builder = RestClient.builder(new HttpHost(ELASTIC_SEARCH_HOSTNAME, ELASTIC_SEARCH_PORT, ELASTIC_SEARCH_SCHEME));
        return new RestHighLevelClient(builder);
    }

    public void close() {
        try {
            restHighLevelClient().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
