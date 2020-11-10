package xin.qust.platform.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.config.login.token.JwtTokenManager;
import xin.qust.platform.domain.EventNode;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.ResponseCode;
import xin.qust.platform.service.common.EventGraphService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("tree")
@RestController
public class TreeApi {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JwtTokenManager jwtTokenManager;

    @Autowired
    private EventGraphService eventGraphService;

    @RequestMapping("getBiaozhuTree")
    public Message getBiaozhuTree () throws IllegalAccessException {
        Object object =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Message message = new Message(ResponseCode.SUCCESS);
        Map<String, List> data  = eventGraphService.getBiaozhunTree();
//        ArrayList<Map> nodes = new ArrayList<>();
//
//        Map<String, Object> node = new HashMap<>();
//        node.put("id",0);
//        node.put("label","A");
//        nodes.add(node);
//
//        Map<String, Object> node2 = new HashMap<>();
//        node2.put("id",1);
//        node2.put("label","B");
//        nodes.add(node2);
//
//
//        Map<String, Object> edge = new HashMap<>();
//        edge.put("from", 0);
//        edge.put("to", 1);
//        ArrayList<Map> edges = new ArrayList<>();
//        edges.add(edge);
//
//
//        Map<String, List> data = new HashMap<>();
//        data.put("db_nodes", nodes);
//        data.put("db_edges", edges);
        message.setData(data);
        String new_token = jwtTokenManager.createToken(object.toString());
        message.setToken(new_token);
        return message;
    }
}
