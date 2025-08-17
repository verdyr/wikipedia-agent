package com.oss.mcpagent;

import com.oss.mcpagent.service.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class McpWikipediaAgentApplication implements CommandLineRunner {

    @Autowired
    private TcpAgentServer tcpServer;

    public static void main(String[] args) {
        SpringApplication.run(McpWikipediaAgentApplication.class, args);
    }

    @Override
    public void run(String... args) {
        tcpServer.startServer();
    }
}
