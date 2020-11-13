package xin.qust.platform.service.common;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.EventBiaozhuPair;
import xin.qust.platform.domain.EventEdge;
import xin.qust.platform.domain.EventNode;
import xin.qust.platform.nlp.WordSplit;
import xin.qust.platform.repository.EventBiaozhuPairRepo;
import xin.qust.platform.repository.EventEdgeRepo;
import xin.qust.platform.repository.EventNodeRepo;


import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EventGraphService {
    @Autowired
    private EventNodeRepo eventNodeRepo;
    @Autowired
    private EventEdgeRepo eventEdgeRepo;

    @Autowired
    private EventBiaozhuPairRepo eventBiaozhuPairRepo;

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

//    获取存在数据库中的标准树
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
//            edgeMap.remove("id");
            edges.add(edgeMap);
        }
        Map<String, List> data = new HashMap<>();
        data.put("db_nodes", nodes);
        data.put("db_edges", edges);
        return data;
    }
    public ArrayList<Map> findByNodeLike(String sentence) throws IllegalAccessException {
        List<EventNode> eventNodes = new ArrayList<>();
        if (sentence.equals("")){
            eventNodes.addAll(eventNodeRepo.findAll());
        }
        else {
            String[] sentences = new String[] {sentence};
            List<List> sp_words = WordSplit.getList(sentences);
            for (Object word : sp_words.get(0)){
                String sword = (String) word;
                try {
//                System.out.println(sword);
                    if(sword.length()==1){continue;}
                    eventNodes.addAll(eventNodeRepo.findByNodeLike((String) word));
                }catch (IndexOutOfBoundsException e){
                    continue;
                }
            }//解决分词节点
        }
        HashSet h = new HashSet(eventNodes);
        eventNodes.clear();
        eventNodes.addAll(h);
//        System.out.println(eventNodes);
        ArrayList<Map> nodes = new ArrayList<>();
        for(int i=0; i<eventNodes.size(); i ++){
            Map<String, Object> nodeMap = getObjectToMap(eventNodes.get(i));
            nodes.add(nodeMap);
        }
        return nodes;
    }
    public void addBiaozhuPair(String anli,String biaozhun){
        EventBiaozhuPair pair = new EventBiaozhuPair();
        pair.setAnli(anli);
        pair.setBiaozhun(biaozhun);
        eventBiaozhuPairRepo.save(pair);
    }

}
