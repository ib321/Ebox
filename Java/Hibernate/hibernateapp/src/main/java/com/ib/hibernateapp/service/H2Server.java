package com.ib.hibernateapp.service;
//package com.ib.hibernateapp.server;

import org.h2.tools.Server;

import java.sql.SQLException;

public class H2Server {

    private static Server server;
    private static Server webServer;

    public static void startServer() throws SQLException {
        server = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
        System.out.println("H2 TCP Server started and listening on port 9092.");
        webServer = Server.createWebServer("-webPort", "8082", "-webAllowOthers").start();
        System.out.println("H2 Web Server started and available at http://localhost:8082");
    }

    public static void stopServer() {
        if (server != null) {
            server.stop();
            System.out.println("H2 TCP Server stopped.");
        }
        if (webServer != null) {
            webServer.stop();
            System.out.println("H2 Web Server stopped.");
        }
    }
}
