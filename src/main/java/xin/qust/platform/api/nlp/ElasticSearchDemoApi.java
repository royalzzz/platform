package xin.qust.platform.api.nlp;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.replication.ReplicationResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.Strings;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.service.common.ElasticService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static xin.qust.platform.utils.ToolKit.mapToJsonString;

@RequestMapping("es_demo")
@RestController
public class ElasticSearchDemoApi {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ElasticService elasticService;

    @RequestMapping("createIndex")
    public void createIndex(String indexName, @RequestBody Map<String, Object> jsonSource) {
        logger.info("index: " + indexName + "\tjson: " + mapToJsonString(jsonSource));
        elasticService.createIndex(indexName, mapToJsonString(jsonSource));
    }

    @RequestMapping("getIndexMapping")
    public boolean getIndexMapping(String indexName) {
        return elasticService.isExistsIndex(indexName);
    }

    @RequestMapping("insertIndex")
    public void insertIndex(String indexName, String id, @RequestBody Map<String, Object> jsonSource) {
        logger.info("index: " + indexName + "\tjson: " + mapToJsonString(jsonSource));
        elasticService.insertOrUpdateOne(indexName, id, mapToJsonString(jsonSource));
    }

    @RequestMapping("getIndex")
    public GetResponse getIndex(String indexName, String id) {
        logger.info("index: " + indexName);
        return elasticService.getIndex(indexName, id);
    }

    @RequestMapping("search")
    public SearchResponse search(String indexName, String key, String value) {
        logger.info("index: " + indexName);
        return elasticService.search(indexName, key, value);
    }
}
