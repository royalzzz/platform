package xin.qust.platform.service.yuqing;

import io.grpc.ManagedChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.yuqing.YuqingOriginnews;
import xin.qust.platform.grpc.proto.TaskYuqingClaGrpc;
import xin.qust.platform.grpc.proto.TaskYuqingClaProto;
import xin.qust.platform.grpc.proxy.ChannelFactory;
import xin.qust.platform.repository.yuqing.NewsClaRepo;
import xin.qust.platform.repository.yuqing.YuqingOriginnewsRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class YuqingOriginnewsService {
    Logger logger = LoggerFactory.getLogger(YuqingOriginnewsService.class);
    @Autowired
    private YuqingOriginnewsRepo yuqingOriginnewsRepo;
    @Autowired
    private NewsClaRepo newsClaRepo;

    public Object getAllYuqingOriginnewsPageable(Pageable pageable) {
        return yuqingOriginnewsRepo.findAll(pageable);
    }

    public Page<YuqingOriginnews> getYuqingOriginnewsWithoutClaPageable(Pageable pageable) {
        return yuqingOriginnewsRepo.findByClasetIsNull(pageable);
    }

    public Page<YuqingOriginnews> getYuqingOriginnewsWithClaPageable(Pageable pageable) {
        return yuqingOriginnewsRepo.findByClasetIsNotNull(pageable);
    }

    public YuqingOriginnews updateOriginNews(YuqingOriginnews news) {
        return yuqingOriginnewsRepo.save(news);
    }
    private List<YuqingOriginnews> getYuqingOriginnewsWithoutCla() {
        return yuqingOriginnewsRepo.findByClasetIsNotNull();
    }
    public int chargeClass() {
//        new Thread(new Runnable(){//调用Runnable接口
//            public void run(){
//                LogBucket.startListen();
//            }
//        }).start();
        //获得所有未标注的新闻
        List<YuqingOriginnews> yuqingOriginnewsList = this.getYuqingOriginnewsWithoutCla();
        for(int i=0;i<yuqingOriginnewsList.size();i++){
            Long id = yuqingOriginnewsList.get(i).getId();
            String content = yuqingOriginnewsList.get(i).getNews_title() + yuqingOriginnewsList.get(i).getNews_content();
            try {
                this.chargeStart(id, content);
                logger.info(LocalDateTime.now().toLocalTime() + "：执行原始新闻分类...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 2;
    }



    public void chargeStart(Long id, String content) throws Exception{
        ManagedChannel channel = ChannelFactory.createGrpcChannel();
        TaskYuqingClaGrpc.TaskYuqingClaBlockingStub stub = TaskYuqingClaGrpc.newBlockingStub(channel);

        String taskId = UUID.randomUUID().toString();
        TaskYuqingClaProto.TaskYuqingClaRequest request = TaskYuqingClaProto.TaskYuqingClaRequest.newBuilder().setTaskId(taskId).setId(id).setContent(content).build();
        TaskYuqingClaProto.TaskYuqingClaReply reply = stub.yuqingCla(request);
        logger.info(reply.getMessage());
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }



}
