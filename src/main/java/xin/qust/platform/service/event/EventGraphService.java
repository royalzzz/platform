package xin.qust.platform.service.event;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.*;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.constant.ResponseCode;
import xin.qust.platform.model.vo.PageVo;
import xin.qust.platform.nlp.WordSplit;
import xin.qust.platform.repository.event.*;


import java.lang.reflect.Field;
import java.util.*;

@Service
public class EventGraphService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private EventNodeRepo eventNodeRepo;
    @Autowired
    private EventEdgeRepo eventEdgeRepo;

    @Autowired
    private EventBiaozhuPairRepo eventBiaozhuPairRepo;

    @Autowired
    private EventTftTableRepo eventTftTableRepo;

    @Autowired
    private EventAccidentReportRepo eventAccidentReportRepo;

    @Autowired
    private EventNodeBiaozhuPairRepo eventNodeBiaozhuPairRepo;

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
    public void addBiaozhuPair(String anli,String biaozhun, Long source, Long sourceid){
        EventBiaozhuPair pair = new EventBiaozhuPair();
        pair.setAnli(anli);
        pair.setBiaozhun(biaozhun);
        pair.setSource(source);
        pair.setSourceid(sourceid);
        eventBiaozhuPairRepo.save(pair);
    }

    public ArrayList<Map> getEventTft() throws IllegalAccessException {
        List<EventTftTable> eventTfts = new ArrayList<>();
        eventTfts.addAll(eventTftTableRepo.findAll());
        ArrayList<Map> tfts = new ArrayList<>();
        for(int i=0; i<eventTfts.size(); i ++){
            Map<String, Object> nodeMap = getObjectToMap(eventTfts.get(i));
            tfts.add(nodeMap);}
        return tfts;
    }

    public ArrayList<Map> getAccidentReport() throws IllegalAccessException {
        List<EventAccidentReport> eventaccidentreports = new ArrayList<>();
        eventaccidentreports.addAll(eventAccidentReportRepo.findAll());
        ArrayList<Map> accidentreports = new ArrayList<>();
        for(int i=0; i<eventaccidentreports.size(); i ++){
            Map<String, Object> nodeMap = getObjectToMap(eventaccidentreports.get(i));
            accidentreports.add(nodeMap);}
        return accidentreports;
    }
    public ArrayList<Map> findBiaozhuPairBySourceid(Long source, Long sourceid) throws IllegalAccessException {
        List<EventBiaozhuPair> eventBiaozhuPairs = eventBiaozhuPairRepo.findBySourceAndSourceid(source,sourceid);
        ArrayList<Map> eventBiaozhuPairMaps = new ArrayList<>();
        for(int i=0; i<eventBiaozhuPairs.size(); i++){
            Map<String, Object> eventBiaozhuPairMap = getObjectToMap(eventBiaozhuPairs.get(i));
            eventBiaozhuPairMaps.add(eventBiaozhuPairMap);
        }
        return eventBiaozhuPairMaps;
    }

    public Message deletePairById(Long id) {
        Message message = new Message();
        Optional<EventBiaozhuPair> eventBiaozhuPair = eventBiaozhuPairRepo.findById(id);
        if (eventBiaozhuPair.isPresent()){
            eventBiaozhuPair.get().setSource(99L);
            eventBiaozhuPairRepo.save(eventBiaozhuPair.get());
            message.setResponseCode(ResponseCode.SUCCESS);
            message.setData("成功，修改source字段的记录值为99");
        }else {
            message.setResponseCode(ResponseCode.RESULE_DATA_NONE);     //数据未找到
            message.setData("失败，所删除的数据未找到");
        }
        return message;
    }

    public Object getEventTftPageable(Pageable pageable) {
        return eventTftTableRepo.findAll(pageable);
    }

    public Object getAccidentReportPageable(Pageable pageable) {
        return eventAccidentReportRepo.findAll(pageable);

    }

    public Message saveReport(EventAccidentReport eventAccidentReport) {
        Message message = new Message();
        try{
            eventAccidentReportRepo.save(eventAccidentReport);
            message.setResponseCode(ResponseCode.SUCCESS);
            return message;
        }catch (Exception e){
            logger.error(e.getMessage());
            message.setResponseCode(ResponseCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
            return  message;
        }
    }

    public Message removeReport(Long id) {
        Message message = new Message();
        try{
            eventAccidentReportRepo.deleteById(id);
            message.setResponseCode(ResponseCode.SUCCESS);
            return message;
        }catch (Exception e){
            logger.error(e.getMessage());
            message.setResponseCode(ResponseCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
            return  message;
        }
    }

//    概念图（标准图）上的节点标注，标注一段文字
    public void addEventNodeBiaozhuPair(Long nodeid,String node, String biaozhutext){
        EventNodeBiaozhuPair pair = new EventNodeBiaozhuPair();
        pair.setBiaozhutext(biaozhutext);
        pair.setNode(node);
        pair.setNodeid(nodeid);
        eventNodeBiaozhuPairRepo.save(pair);
    }

//    通过nodeid获得标注记录
    public List<EventNodeBiaozhuPair> findEventNodeBiaozhuPairbyNodeid(Long nodeid) {
        return eventNodeBiaozhuPairRepo.findByNodeid(nodeid);
    }

    public Object findAllEventNodeBiaozhuPair(Pageable pageable) {
        return eventNodeBiaozhuPairRepo.findAll(pageable);
    }

    public void deleteNodeBiaozhuPairById(Long id) {
        eventNodeBiaozhuPairRepo.deleteById(id);
    }
}
