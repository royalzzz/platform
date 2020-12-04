package xin.qust.platform.api.yuqing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.domain.yuqing.YuqingOriginnews;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.constant.ResponseCode;
import xin.qust.platform.model.vo.PageVo;
import xin.qust.platform.service.sysconf.SystemConfigService;
import xin.qust.platform.service.yuqing.YuqingOriginnewsService;

import javax.persistence.Convert;
import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

@RequestMapping("yuqing")
@RestController
public class yuqingApi {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SystemConfigService systemConfigService;
    @Autowired
    private YuqingOriginnewsService yuqingOriginnewsService;

    @RequestMapping("setCrawlerParams")
    public Message setCrawlerParams(String s_key,int s_time, String s_date) throws Exception {
        System.out.println(s_date);
        Message message = new Message();
        try{
//        skey=关键字；stime=时间间隔；sdate=开始时间;
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
            System.out.println(df.parse(s_date).getSeconds());
            int month = df.parse(s_date).getMonth()+1;
            int day = df.parse(s_date).getDay()-1;
            int hours = df.parse(s_date).getHours();
            int minutes = df.parse(s_date).getMinutes();
            int seconds = df.parse(s_date).getSeconds();

            Map<String,Object> params = new HashMap<>();
            String cornStr = seconds+" "+minutes+" "+hours+"/"+s_time+" "+day+" "+month+" ?";
            System.out.println(cornStr);
            params.put("yuqing_crawler_time_split",cornStr);
            params.put("yuqing_crawler_start_time",s_date);
            params.put("yuqing_crawler_keywords",s_key);
            systemConfigService.addSysConfig(params);
            message.setResponseCode(ResponseCode.SUCCESS);
            message.setData("已经收到舆情爬虫参数");
            logger.info("设置舆情爬虫参数："+s_key+"|"+s_time+"|"+s_date);
        }catch (Exception e){
            message.setResponseCode(ResponseCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
            message.setData("设置舆情模块爬虫参数 错误。" + e.getMessage());
        }
        return message;
    }
    @RequestMapping("getAllYuqingOriginnewsPageable")
    public Message getAllYuqingOriginnewsPageable(@RequestBody PageVo pageVo) {
        Message message = new Message();
        try {
            message.setResponseCode(ResponseCode.SUCCESS).setData(yuqingOriginnewsService.getAllYuqingOriginnewsPageable(pageVo));
            return message;
        }catch (Exception e){
            message.setResponseCode(ResponseCode.SUCCESS).setData(e.getMessage());
            return message;
        }
    }
}
