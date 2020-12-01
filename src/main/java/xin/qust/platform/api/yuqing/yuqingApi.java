package xin.qust.platform.api.yuqing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.constant.ResponseCode;
import xin.qust.platform.service.sysconf.SystemConfigService;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("yuqing")
@RestController
public class yuqingApi {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SystemConfigService systemConfigService;

    @RequestMapping("setCrawlerParams")
    public Message setCrawlerParams(String s_key,String s_time, String s_date) throws Exception {
//        String data = httpServletRequest.getParameter("data");
//        String password = httpServletRequest.getParameter("password");
        Message message = new Message();
        try{
            Map<String,Object> params = new HashMap<>();
            params.put("yuqing_crawler_time_split",s_time);
            params.put("yuqing_crawler_start_time",s_date);
            params.put("yuqing_crawler_keywords",s_key);
            systemConfigService.addSysConfig(params);
//        skey=关键字；stime=时间间隔；sdate=开始时间;
            message.setResponseCode(ResponseCode.SUCCESS);
            message.setData("已经收到舆情爬虫参数");
            logger.info("设置舆情爬虫参数："+s_key+"|"+s_time+"|"+s_date);
        }catch (Exception e){
            message.setResponseCode(ResponseCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
            message.setData("设置舆情模块爬虫参数 错误。" + e.getMessage());
        }
        return message;
    }
}
