package xin.qust.platform.grpc.proxy;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ChannelFactory {

	private static final String host = "localhost";
	private static final int port = 5001;

	public static ManagedChannel createGrpcChannel() {

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
		return channel;
	}
	
}
