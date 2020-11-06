package xin.qust.platform.api;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("tree")
@RestController
public class TreeApi {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("getTree")
    public Map<String, String> register () {
        logger.info("获得树数据");
        System.out.println("树");
        String nodes = "[{id:1,label:'A'},{id:2,label:'B'},{id:3,label:'C'},{id:4,label:'D'}]";
        String edges = "[{from:1,to:3},{from:1,to:2},{from:2,to:4}]";
        Map<String, String> res = new HashMap<>();
        res.put("nodes", nodes);
        res.put("edges", edges);
        return res;
    }

}
