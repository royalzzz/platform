package xin.qust.platform.schedule.yuqing;

import io.grpc.ManagedChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xin.qust.platform.grpc.proto.TaskCrawlerProto;
import xin.qust.platform.grpc.proto.taskcrawlerGrpc;
import xin.qust.platform.grpc.proxy.ChannelFactory;
import xin.qust.platform.grpc.proxy.LogBucket;
import xin.qust.platform.grpc.test.ClientTest;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CrawlerTaskRunable {

    public void crawlerStart() throws Exception{
        Logger logger = LoggerFactory.getLogger(CrawlerTaskRunable.class);
        ManagedChannel channel = ChannelFactory.createGrpcChannel();
        taskcrawlerGrpc.taskcrawlerBlockingStub stub = taskcrawlerGrpc.newBlockingStub(channel);

        String taskId = UUID.randomUUID().toString();
        TaskCrawlerProto.Crawler1Request request = TaskCrawlerProto.Crawler1Request.newBuilder().setTaskId(taskId).setKeywords("['化工爆炸', '化工泄露', '化工中毒', '化工火灾']").build();
        TaskCrawlerProto.Crawler1Reply reply = stub.crawler1(request);
        logger.info(reply.getMessage());
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public static void runCrawler(){
        Logger logger = LoggerFactory.getLogger(CrawlerTaskRunable.class);
//        new Thread(new Runnable(){//调用Runnable接口
//            public void run(){
//                LogBucket.startListen();
//            }
//        }).start();

        try {
            CrawlerTaskRunable crawlerTask = new CrawlerTaskRunable();
            crawlerTask.crawlerStart();
            logger.info(LocalDateTime.now().toLocalTime() + "：执行爬虫...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
