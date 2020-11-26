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
import org.elasticsearch.action.support.master.AcknowledgedResponse;
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
import xin.qust.platform.domain.KbqaSdsChemical;
import xin.qust.platform.model.Message;
import xin.qust.platform.repository.kbqa.KbqaSdsChemicalRepo;
import xin.qust.platform.service.common.ElasticService;
import xin.qust.platform.service.kbqa.ProcessChemicalService;

import java.util.*;

import static xin.qust.platform.utils.ToolKit.mapToJsonString;

@RequestMapping("kbqa/es_demo")
@RestController
public class ElasticSearchDemoApi {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ElasticService elasticService;
    @Autowired
    private ProcessChemicalService processChemicalService;

    @RequestMapping("createIndex")
    public void createIndex(String indexName, @RequestBody Map<String, Object> jsonSource) {
        logger.info("create index: " + indexName + "\tjson: " + mapToJsonString(jsonSource));
        elasticService.createIndex(indexName, mapToJsonString(jsonSource));
    }

    @RequestMapping("getIndexMapping")
    public boolean getIndexMapping(String indexName) {
        return elasticService.isExistsIndex(indexName);
    }

    @RequestMapping("insertIndex")
    public void insertIndex(String indexName, String id, @RequestBody Map<String, Object> jsonSource) {
        logger.info("insert index: " + indexName + "\tjson: " + mapToJsonString(jsonSource));
        elasticService.insertOrUpdateOne(indexName, id, mapToJsonString(jsonSource));
    }

    @RequestMapping("insertBulkIndex")
    public void insertBulkIndex(String indexName, @RequestBody List<Map<String, Object>> jsonSource) {
        elasticService.insertBatch(indexName, jsonSource);
    }

    @RequestMapping("getIndex")
    public GetResponse getIndex(String indexName) {
        return elasticService.getIndex(indexName);
    }

    @RequestMapping("deleteIndex")
    public AcknowledgedResponse deleteIndex(String indexName) {
        logger.info("delete index: " + indexName);
        return elasticService.deleteIndex(indexName);
    }

    @RequestMapping("search")
    public Message search(String indexName, String key, String value) {
        if (indexName == null) {
            return Message.createSuccessMessage(elasticService.searchByKey(key, value));
        }
        else {
            return Message.createSuccessMessage(elasticService.searchByIndexAndKey(indexName, key, value));
        }
    }

    @RequestMapping("sds")
    public Message sds() {
        processChemicalService.importSDS("chemical");
        return Message.createSuccessMessage();
    }

}
