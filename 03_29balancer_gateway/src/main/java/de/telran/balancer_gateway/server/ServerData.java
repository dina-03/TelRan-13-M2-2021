package de.telran.balancer_gateway.server;

import java.util.Objects;

public class ServerData {

    private String host;
    private int port;

    public ServerData(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ServerData that = (ServerData) o;
        return Objects.equals(host, that.host) && Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, port);
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
