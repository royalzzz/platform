package xin.qust.platform.grpc.proxy;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ChannelFactory {

	private String host = "localhost";
	private int port = 5001;

	public ManagedChannel createGrpcChannel() {

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
		return channel;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
