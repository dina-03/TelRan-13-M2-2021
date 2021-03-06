package de.telran.balancer_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Component
public class TcpOuterListener {
    int tcpOuterPort;
    private final ServerProxy serverProxy;

    public TcpOuterListener(@Value("${tcp.outer.port}")
                                    int tcpOuterPort,
                            ServerProxy serverProxy) {
        this.tcpOuterPort = tcpOuterPort;
        this.serverProxy = serverProxy;
    }

    public void run() throws IOException {
        System.out.println("tcp balancer listener");
        ServerSocket serverSocket = new ServerSocket(tcpOuterPort);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            serverProxy.handleConnection(socket);
        }
    }
}
