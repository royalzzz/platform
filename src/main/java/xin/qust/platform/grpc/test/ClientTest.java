package xin.qust.platform.grpc.test;

import xin.qust.platform.grpc.proxy.ChannelFactory;
import xin.qust.platform.grpc.proxy.LogBucket;
import xin.qust.platform.grpc.proxy.LogHandler;
import xin.qust.platform.grpc.proto.*;
import io.grpc.ManagedChannel;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ClientTest {


	public void test1() throws Exception{


		String taskId = UUID.randomUUID().toString();


		LogBucket.addListener(taskId, new LogHandler(){
			@Override
			public void handle(String message) {
				System.out.println("Task: "+taskId+" receive message: "+message);
			}
		});

		ManagedChannel channel = ChannelFactory.createGrpcChannel();
		Server1Grpc.Server1BlockingStub stub = Server1Grpc.newBlockingStub(channel);
		Server1Proto.Fun1Request request = Server1Proto.Fun1Request.newBuilder().setTaskId(taskId).setParam("p1").build();
		Server1Proto.Fun1Reply reply = stub.fun1(request);
		System.out.println(reply.getMessage());

		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}


	public void test2() throws Exception{

		ManagedChannel channel = ChannelFactory.createGrpcChannel();
		Server2Grpc.Server2BlockingStub stub = Server2Grpc.newBlockingStub(channel);

		String taskId = UUID.randomUUID().toString();
		Server2Proto.Fun2Request request = Server2Proto.Fun2Request.newBuilder().setTaskId(taskId).setParam("p2").build();
		Server2Proto.Fun2Reply reply = stub.fun2(request);
		System.out.println(reply.getMessage());

		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	public void taskCrawler() throws Exception{
        ManagedChannel channel = ChannelFactory.createGrpcChannel();
        taskcrawlerGrpc.taskcrawlerBlockingStub stub = taskcrawlerGrpc.newBlockingStub(channel);

        String taskId = UUID.randomUUID().toString();
        TaskCrawlerProto.Crawler1Request request = TaskCrawlerProto.Crawler1Request.newBuilder().setTaskId(taskId).setKeywords("['化工爆炸', '化工泄露', '化工中毒', '化工火灾']").build();
        TaskCrawlerProto.Crawler1Reply reply = stub.crawler1(request);
        System.out.println(reply.getMessage());
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


	public void testTaskManage() throws Exception{

		ManagedChannel channel = ChannelFactory.createGrpcChannel();
		TaskManageGrpc.TaskManageBlockingStub stub = TaskManageGrpc.newBlockingStub(channel);


		TaskManageProto.ListActiveRequest request = TaskManageProto.ListActiveRequest.newBuilder().build();
		TaskManageProto.ListActiveReply reply = stub.listActiveTask(request);
		System.out.println(reply.getTasksList());

		Thread.sleep(1000);

		String ft = reply.getTasksList().get(0);
		TaskManageProto.KillRequest request1 = TaskManageProto.KillRequest.newBuilder().setTaskId(ft).build();
		stub.killTask(request1);

		Thread.sleep(1000);

		TaskManageProto.ListActiveRequest request2 = TaskManageProto.ListActiveRequest.newBuilder().build();
		TaskManageProto.ListActiveReply reply2 = stub.listActiveTask(request2);
		System.out.println(reply2.getTasksList());

		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}



	public static void main(String[] args) {


		new Thread(new Runnable(){//调用Runnable接口
	    	public void run(){
	    		LogBucket.startListen();
	    	}
	    }).start();

		try {
			xin.qust.platform.grpc.test.ClientTest t = new xin.qust.platform.grpc.test.ClientTest();
//			t.test1();
//			t.test1();
//			t.test1();
//			t.test2();
            t.taskCrawler();
			System.out.println("-------------------------");
//			t.testTaskManage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
