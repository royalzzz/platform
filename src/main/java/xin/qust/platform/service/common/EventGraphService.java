package xin.qust.platform.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.EventEdge;
import xin.qust.platform.domain.EventNode;
import xin.qust.platform.repository.EventEdgeRepo;
import xin.qust.platform.repository.EventNodeRepo;


import java.lang.reflect.Field;
import java.util.*;

@Service
public class EventGraphService {
    @Autowired
    private EventNodeRepo eventNodeRepo;
    @Autowired
    private EventEdgeRepo eventEdgeRepo;

    //对象转Map
    public static Map<String, Object> getObjectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if (value == null){
                value = "";
            }
            map.put(fieldName, value);
        }
        return map;
    }

    public Map<String, List> getBiaozhunTree() throws IllegalAccessException {
        List<EventNode> eventNodes = eventNodeRepo.findAll();
        List<EventEdge> eventEdges = eventEdgeRepo.findAll();

        ArrayList<Map> nodes = new ArrayList<>();
        for(int i=0; i<eventNodes.size(); i ++){
            Map<String, Object> nodeMap = getObjectToMap(eventNodes.get(i));
            nodes.add(nodeMap);
        }
        ArrayList<Map> edges = new ArrayList<>();
        for(int i=0; i<eventEdges.size(); i ++){
            Map<String, Object> edgeMap = getObjectToMap(eventEdges.get(i));
            edgeMap.remove("id");
            edges.add(edgeMap);
        }
        Map<String, List> data = new HashMap<>();
        data.put("db_nodes", nodes);
        data.put("db_edges", edges);
        return data;

    }
}
