package xin.qust.platform.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.constant.ResponseCode;

@RequestMapping("yuqing")
@RestController
public class yuqingApi {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("setCrawlerParams")
    public Message setCrawlerParams(String s_key,String s_time, String s_date) {
//        String data = httpServletRequest.getParameter("data");
//        String password = httpServletRequest.getParameter("password");
        Message message = new Message();
        message.setResponseCode(ResponseCode.SUCCESS);
        message.setData("sdhjyvbdjhs");
//        skey=关键字；stime=时间间隔；sdate=开始时间
        logger.info("设置舆情爬虫参数："+s_key+"|"+s_time+"|"+s_date);
        return message;
    }
}
