package xin.qust.platform.api.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.config.login.plugins.jwt.JwtTokenManager;
import xin.qust.platform.domain.event.EventAccidentReport;
import xin.qust.platform.domain.event.EventNodeBiaozhuPair;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.constant.ResponseCode;
import xin.qust.platform.model.vo.PageVo;
import xin.qust.platform.service.event.EventGraphService;

import java.text.ParseException;
import java.util.ArrayList;
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
        message.setData(data);
        String new_token = jwtTokenManager.createToken(object.toString());
        message.setToken(new_token);
        return message;
    }

    @RequestMapping("findByLabelLike")
    public Message findByNodeLike(String keyword) throws IllegalAccessException {

        ArrayList<Map> nodes = eventGraphService.findByNodeLike(keyword);
        Message message = new Message(ResponseCode.SUCCESS);
        message.setData(nodes);
        return message;
    }

    @RequestMapping("addBiaozhuPair")
    public Message addBiaozhuPair(String anli,String biaozhun, Long source, Long sourceid) throws IllegalAccessException, ParseException {
        eventGraphService.addBiaozhuPair(anli, biaozhun, source, sourceid);
        Message message = new Message(ResponseCode.SUCCESS);
        message.setData("插入成功");
        return message;
    }

    @RequestMapping("getEventTft")
    public Message getEventTft() throws IllegalAccessException {
        ArrayList<Map> reports = eventGraphService.getEventTft();
        Message message = new Message(ResponseCode.SUCCESS);
        message.setData(reports);
        return message;
    }

    @RequestMapping("getEventTftPageable")
    public Message getEventTftPageable(@RequestBody PageVo pageVo) {
//        logger.info(pageVo.toString());
        return Message.createSuccessMessage(eventGraphService.getEventTftPageable(pageVo));
    }

    @RequestMapping("getAccidentReport")
    public Message getAccidentReport() throws IllegalAccessException {
        ArrayList<Map> reports = eventGraphService.getAccidentReport();
        Message message = new Message(ResponseCode.SUCCESS);
        message.setData(reports);
        return message;
    }

    @RequestMapping("getAccidentReportPageable")
    public Message getAccidentReportPageable(@RequestBody PageVo pageVo) {
        return Message.createSuccessMessage(eventGraphService.getAccidentReportPageable(pageVo));
    }


    @RequestMapping("findBiaozhuPairBySourceid")
    public Message findBiaozhuPairBySourceid(Long source, Long sourceid) throws IllegalAccessException {
        ArrayList<Map> MapList = eventGraphService.findBiaozhuPairBySourceid(source, sourceid);
        Message message = new Message(ResponseCode.SUCCESS);
        message.setData(MapList);
        return message;
    }

    @RequestMapping("deletePairById")
    public Message deletePairById(Long id) {
//        不删除，设置source值为99
        Message message = eventGraphService.deletePairById(id);
        return message;
    }

    @RequestMapping("saveReport")
    public Message saveReport(@RequestBody EventAccidentReport eventAccidentReport) {
        return eventGraphService.saveReport(eventAccidentReport);
    }

    @RequestMapping("removeReport")
    public Message removeReport(Long id) {
        return eventGraphService.removeReport(id);
    }

    @RequestMapping("addEventNodeBiaozhuPair")
    public Message addEventNodeBiaozhuPair(Long id, String label, String biaozhutext){
        Message message = new Message();
        try{
//            System.out.println(biaozhutext);
            eventGraphService.addEventNodeBiaozhuPair(id, label, biaozhutext);
            message.setResponseCode(ResponseCode.SUCCESS).setData("插入概念图节点标注 成功。");
        }catch (Exception e){
            message.setResponseCode(ResponseCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST).setData("插入概念图节点标注 出错。");
        }
        return message;
    }
    @RequestMapping("findEventNodeBiaozhuPairbyNodeid")
    public Message findEventNodeBiaozhuPairbyNodeid(Long nodeid) {
        Message message = new Message();
        try {
            List<EventNodeBiaozhuPair> eventNodeBiaozhuPairs = eventGraphService.findEventNodeBiaozhuPairbyNodeid(nodeid);
            message.setResponseCode(ResponseCode.SUCCESS).setData(eventNodeBiaozhuPairs);
        }catch (Exception e){
            message.setResponseCode(ResponseCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST).setData("通过nodeid获得标注记录 出错。");
        }
        return message;
    }
    @RequestMapping("findAllEventNodeBiaozhuPairPageable")
    public Message findAllEventNodeBiaozhuPairPageable(@RequestBody PageVo pageVo) {
        Message message = new Message();
        try {
            Object eventNodeBiaozhuPairs = eventGraphService.findAllEventNodeBiaozhuPair(pageVo);
            message.setResponseCode(ResponseCode.SUCCESS).setData(eventNodeBiaozhuPairs);
        }catch (Exception e){
            message.setResponseCode(ResponseCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST).setData("通过nodeid获得标注记录 出错。");
        }
        return message;
    }
    @RequestMapping("deleteNodeBiaozhuPairById")
    public Message deleteNodeBiaozhuPairById(Long id) {
        Message message = new Message();
        try {
            eventGraphService.deleteNodeBiaozhuPairById(id);
            message.setResponseCode(ResponseCode.SUCCESS).setData("已经成功删除标准图节点的一个标注记录， Id：" + id.toString());
        }catch (Exception e) {
            message.setResponseCode(ResponseCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST).setData("删除标准图节点的一个标注记录 出错。");
        }
        return message;
    }
}
