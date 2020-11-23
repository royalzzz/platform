package xin.qust.platform.api.nlp;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("es_demo")
@RestController
public class ElasticSearchDemoApi {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @RequestMapping("index")
    public String index() {
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("1")
                .source("user", "royal",
                        "postDate", new Date(),
                        "message", "trying out Elasticsearch");
        try {
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            String index = indexResponse.getIndex();
            String id = indexResponse.getId();
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {

            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {

            }
            ReplicationResponse.ShardInfo shardInfo = indexResponse.getShardInfo();
            if (shardInfo.getTotal() != shardInfo.getSuccessful()) {

            }
            if (shardInfo.getFailed() > 0) {
                for (ReplicationResponse.ShardInfo.Failure failure :
                        shardInfo.getFailures()) {
                    String reason = failure.reason();
                }
            }
            return indexResponse.toString();
        }
        catch (Exception e) {
            logger.warn("index error");
        }
        return "";
    }

    @RequestMapping("indexAsync")
    public void indexAsync() {
        IndexRequest indexRequest = new IndexRequest("posts")
                .id("1")
                .source("user", "royal",
                        "postDate", new Date(),
                        "message", "trying out Elasticsearch");
        restHighLevelClient.indexAsync(indexRequest, RequestOptions.DEFAULT, new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    @RequestMapping("get")
    private void get() {
        GetRequest getRequest = new GetRequest(
                "posts",
                "1");

        String[] includes = new String[]{"message", "*Date"};
        String[] excludes = Strings.EMPTY_ARRAY;
        FetchSourceContext fetchSourceContext =
                new FetchSourceContext(true, includes, excludes);
        getRequest.fetchSourceContext(fetchSourceContext);

//        String[] includes = Strings.EMPTY_ARRAY;
//        String[] excludes = new String[]{"message"};
//        FetchSourceContext fetchSourceContext =
//                new FetchSourceContext(true, includes, excludes);
//        getRequest.fetchSourceContext(fetchSourceContext);

        try {
            getRequest.storedFields("message");
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            String message = getResponse.getField("message").getValue();
            logger.info(message);
        }
        catch (Exception e) {

        }
    }
}
