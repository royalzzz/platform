package xin.qust.platform.schedule.yuqing;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import xin.qust.platform.domain.system.SystemConfig;
import xin.qust.platform.service.sysconf.SystemConfigService;

import java.util.Optional;

@Configuration
@EnableScheduling
public class CrawlerTask implements SchedulingConfigurer {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SystemConfigService systemConfigService;
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () ->
                    CrawlerTaskRunable.runCrawler(),

                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    Optional<SystemConfig> op = systemConfigService.getSysConfig();
                    if (op.isPresent()){
                        SystemConfig systemConfig = op.get();
                        String cron = systemConfig.getYuqing_crawler_time_split();
//                        cron = getRealCron(cron);
                        logger.info("cron周期运行参数："+cron);
                        //2.2 合法性校验.
                        if (StringUtils.isEmpty(cron)) {
                            logger.error("获取时间失败，舆情模块信息采集未启动");
                        }
                        //2.3 返回执行周期(Date)
                        return new CronTrigger(cron).nextExecutionTime(triggerContext);
                    }
                    return null;
                }
        );
    }
//    返回去掉日期的参数，可以每日都循环
    public static String getRealCron(String cronWithDate){
//        String str2 = "23 40 16/1 2 12 ? ";
        String [] strArray = cronWithDate.split("\\s+");
        String perHour = strArray[2].split("/")[1];
        String second = cronWithDate.split("\\s+")[0];
        String minute = cronWithDate.split("\\s+")[1];
        return second+" "+minute+" 0/"+perHour+" * * ? ";
    }
}
