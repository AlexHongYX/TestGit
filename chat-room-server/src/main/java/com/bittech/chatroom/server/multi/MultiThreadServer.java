package com.bittech.chatroom.server.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: secondriver
 * Created: 2019/5/16
 */
public class MultiThreadServer {
    
    public static void main(String[] args) {
        /*
          问题：
          1. 端口，线程数
          配置：
          1. args   命令行参数
          2. Properties  属性文件 (k=v)
          3. 数据库
          4. ....
          命令参数：
          java  主类   args1  args2 ...
          java MultiTreadServer  8080 10
          //Linux Window java
          java MultiThreadServer --port=8080 --thread=10
         */
        int defaultPort = 8080;
        int defaultThread = 10;
        int port = defaultPort;
        int thread = defaultThread;
        
        for (String arg : args) {
            if (arg.startsWith("--port=")) {
                String portStr = arg.substring("--port=".length());
                try {
                    
                    port = Integer.parseInt(portStr);
                } catch (NumberFormatException e) {
                    port = defaultPort;
                }
            }
            if (arg.startsWith("--thread=")) {
                String threadStr = arg.substring("--thread=".length());
                try {
                    thread = Integer.parseInt(threadStr);
                } catch (NumberFormatException e) {
                    thread = defaultThread;
                }
                
            }
        }
        try {
            final ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器启动：" + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort() + "  线程数：" + thread);
            
            //线程池调度器
            final ExecutorService executorService =
                    Executors.newFixedThreadPool(thread);
            
            while (true) {
                final Socket socket = serverSocket.accept();
                executorService.execute(new ClientHandler(socket));
            }
            
        } catch (IOException e) {
        
        }
        
    }
}
